package ru.ssau.blazebankcardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ssau.blazebankcardservice.entities.CardDTO;
import ru.ssau.blazebankcardservice.service.CardService;

import java.util.UUID;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/save")
    public void createNewCard(@RequestBody CardDTO cardDTO) {
        cardService.addNewCard(cardDTO);
    }

    @GetMapping("/get/id")
    public CardDTO getCardById(@RequestParam UUID uuid) {
        return cardService.getCardDTOById(uuid);
    }

    @GetMapping("/get/userId")
    public CardDTO getCardByUserId(@RequestParam UUID userId) {
        return cardService.getCardDTOByUserId(userId);
    }
}
