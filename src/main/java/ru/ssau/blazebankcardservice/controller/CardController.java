package ru.ssau.blazebankcardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ssau.blazebankcardservice.entities.*;
import ru.ssau.blazebankcardservice.service.CardService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/save")
    public SuccessResponse createNewCard(@RequestBody CardDTO cardDTO) throws ParseException {
        cardService.addCard(cardDTO);
        return SuccessResponse.builder().msg("Card created").build();
    }

    @GetMapping("/get/id")
    public CardDTO getCardById(@RequestParam Integer uuid) {
        return cardService.getCardById(uuid);
    }

    @GetMapping("/get/userId")
    public CardDTO getCardByUserId(@RequestParam String userId) {
        return cardService.getCardByUserId(userId);
    }

    @GetMapping("/check")
    public CardExistsDTO checkIfCardExists(@RequestParam String cardNumber, @RequestParam String accountNumber) {
        return cardService.checkIfCardExists(cardNumber, accountNumber);
    }

    @PostMapping("/balance/update")
    public BalanceUpdateDTO updateBalance(@RequestBody IncomingBalanceChangesDTO incomingBalanceChangesDTO) {
        return cardService.updateBalance(incomingBalanceChangesDTO);
    }

    @GetMapping("/get/cards")
    public List<CardDTO> getAllUserCards() {
        return cardService.getAllUserCards();
    }
}
