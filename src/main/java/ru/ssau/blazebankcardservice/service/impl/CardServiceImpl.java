package ru.ssau.blazebankcardservice.service.impl;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import ru.ssau.blazebankcardservice.entities.*;
import ru.ssau.blazebankcardservice.exceptions.CardNotFoundException;
import ru.ssau.blazebankcardservice.mappers.CardMapper;
import ru.ssau.blazebankcardservice.repositories.CardRepository;
import ru.ssau.blazebankcardservice.service.CardService;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public void addCard(CardDTO cardDTO) throws ParseException {
        Card card = cardMapper.cardDTOToCard(cardDTO);
        card.setUserId(((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getSubject());
        System.out.println("Creating card: " + card);
        cardRepository.save(card);
    }

    @Override
    public CardDTO getCardById(Integer id) {
        System.out.println("Trying to get card with id" + id);
        Card card = cardRepository.findById(id).orElse(null);
        if (card == null) {
            throw new CardNotFoundException("Card with id " + id + " not found");
        }
        return cardMapper.cardToCardDTO(card);
    }

    @Override
    public CardDTO getCardByUserId(String userId) {
        System.out.println("Trying to get card with userId" + userId);
        Card card = cardRepository.findCardByUserId(userId).orElse(null);
        return cardMapper.cardToCardDTO(card);
    }

    @Override
    public CardExistsDTO checkIfCardExists(String cardNumber, String accountNumber) {
        Optional<Card> card = cardRepository.findCardByCardNumberAndAccountNumber(cardNumber, accountNumber);
        System.out.println("Checking if card " + cardNumber + "is present");
        return new CardExistsDTO(card.isPresent());
    }

    @Override
    public BalanceUpdateDTO updateBalance(IncomingBalanceChangesDTO incomingBalanceChangesDTO) {
        Optional<Card> cardChecker = cardRepository.findCardByCardNumberAndAccountNumber(incomingBalanceChangesDTO.getCardNumber(), incomingBalanceChangesDTO.getAccountNumber());

        if (cardChecker.isEmpty()) throw new CardNotFoundException("Card " + incomingBalanceChangesDTO.getCardNumber() + " not found");

        Card card = cardChecker.get();

        card.setBalance(card.getBalance().add(BigInteger.valueOf(incomingBalanceChangesDTO.getBalanceChange())));

        if (card.getBalance().compareTo(BigInteger.ZERO) == -1) {
            return new BalanceUpdateDTO(500, "Balance will become negative!");
        }

        cardRepository.save(card);

        return new BalanceUpdateDTO(200, "Balance was updated!");
    }

    @Override
    public List<CardDTO> getAllUserCards() {
        String userId = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getSubject();
        List<Card> userCards = cardRepository.findAllByUserId(userId);

        return cardMapper.listOfCardsToCardDTO(userCards);
    }
}
