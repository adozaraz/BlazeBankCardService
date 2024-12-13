package ru.ssau.blazebankcardservice.service;

import ru.ssau.blazebankcardservice.entities.BalanceUpdateDTO;
import ru.ssau.blazebankcardservice.entities.CardDTO;
import ru.ssau.blazebankcardservice.entities.CardExistsDTO;
import ru.ssau.blazebankcardservice.entities.IncomingBalanceChangesDTO;

import java.util.UUID;

public interface CardService {
    void addCard(CardDTO card);
    CardDTO getCardById(Integer id);
    CardDTO getCardByUserId(Integer userId);

    CardExistsDTO checkIfCardExists(String cardNumber, String accountNumber);

    BalanceUpdateDTO updateBalance(IncomingBalanceChangesDTO incomingBalanceChangesDTO);
}
