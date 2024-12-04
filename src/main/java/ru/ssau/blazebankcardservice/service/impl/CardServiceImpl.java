package ru.ssau.blazebankcardservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ssau.blazebankcardservice.entities.Card;
import ru.ssau.blazebankcardservice.entities.CardDTO;
import ru.ssau.blazebankcardservice.mappers.CardMapper;
import ru.ssau.blazebankcardservice.repositories.CardRepository;
import ru.ssau.blazebankcardservice.service.CardService;

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
        cardRepository.save(card);
    }

    @Override
    public CardDTO getCardById(UUID uuid) {
        Card card = cardRepository.findById(uuid).orElse(null);
        return cardMapper.cardToCardDTO(card);
    }

    @Override
    public CardDTO getCardByUserId(UUID userId) {
        Card card = cardRepository.findCardByUserId(userId).orElse(null);
        return cardMapper.cardToCardDTO(card);
    }
}
