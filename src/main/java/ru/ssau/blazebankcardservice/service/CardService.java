package ru.ssau.blazebankcardservice.service;

import ru.ssau.blazebankcardservice.entities.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardService {
    void addCard(CardDTO card) throws ParseException;
    CardDTO getCardById(Integer id);
    CardDTO getCardByUserId(String userId);

    CardExistsDTO checkIfCardExists(String cardNumber, Optional<String> accountNumber);

    BalanceUpdateDTO updateBalance(IncomingBalanceChangesDTO incomingBalanceChangesDTO);

    List<CardDTO> getAllUserCards();

    VerifiedStatusDTO verifyCardCvv(VerifyCardDTO verifyCardDTO);
}
