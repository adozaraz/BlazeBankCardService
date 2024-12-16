package ru.ssau.blazebankcardservice.service;

import ru.ssau.blazebankcardservice.entities.BalanceUpdateDTO;
import ru.ssau.blazebankcardservice.entities.CardDTO;
import ru.ssau.blazebankcardservice.entities.CardExistsDTO;
import ru.ssau.blazebankcardservice.entities.IncomingBalanceChangesDTO;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

public interface CardService {
    void addCard(CardDTO card) throws ParseException;
    CardDTO getCardById(Integer id);
    CardDTO getCardByUserId(String userId);

    CardExistsDTO checkIfCardExists(String cardNumber, String accountNumber);

    BalanceUpdateDTO updateBalance(IncomingBalanceChangesDTO incomingBalanceChangesDTO);

    List<CardDTO> getAllUserCards();
}
