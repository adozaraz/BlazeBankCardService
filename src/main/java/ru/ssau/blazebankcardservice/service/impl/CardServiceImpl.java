package ru.ssau.blazebankcardservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ssau.blazebankcardservice.entities.*;
import ru.ssau.blazebankcardservice.exceptions.CardNotFoundException;
import ru.ssau.blazebankcardservice.mappers.CardMapper;
import ru.ssau.blazebankcardservice.repositories.CardRepository;
import ru.ssau.blazebankcardservice.service.CardService;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public void addCard(CardDTO cardDTO) {
        Card card = cardMapper.cardDTOToCard(cardDTO);
        System.out.println(card.toString());
        cardRepository.save(card);
    }

    @Override
    public CardDTO getCardById(Integer id) {
        Card card = cardRepository.findById(id).orElse(null);
        if (card == null) {
            throw new CardNotFoundException("Card with id " + id + " not found");
        }
        return cardMapper.cardToCardDTO(card);
    }

    @Override
    public CardDTO getCardByUserId(Integer userId) {
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
}
