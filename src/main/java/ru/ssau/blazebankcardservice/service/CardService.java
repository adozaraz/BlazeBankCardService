package ru.ssau.blazebankcardservice.service;

import ru.ssau.blazebankcardservice.entities.CardDTO;

import java.util.UUID;

public interface CardService {
    void addCard(CardDTO card);
    CardDTO getCardById(UUID id);
    CardDTO getCardByUserId(UUID userId);
}
