package ru.ssau.blazebankcardservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ssau.blazebankcardservice.entities.Card;
import ru.ssau.blazebankcardservice.entities.CardDTO;
import ru.ssau.blazebankcardservice.mappers.CardMapper;
import ru.ssau.blazebankcardservice.repositories.CardRepository;

import java.util.UUID;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    public void addNewCard(CardDTO cardDTO) {
        Card card = cardMapper.cardDTOToCard(cardDTO);
        cardRepository.save(card);
    }

    public CardDTO getCardDTOById(UUID uuid) {
        Card card = cardRepository.findById(uuid).orElse(null);
        return cardMapper.cardToCardDTO(card);
    }

    public CardDTO getCardDTOByUserId(UUID userId) {
        Card card = cardRepository.findCardByUserId(userId).orElse(null);
        return cardMapper.cardToCardDTO(card);
    }
}
