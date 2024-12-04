package ru.ssau.blazebankcardservice.entities;

import lombok.Builder;

@Builder
public class CardDTO {
    private String id;
    private String userId;
    private String cardNumber;
    private String accountNumber;
    private String expirationDate;
    private String cardType;
    private String walletType;
    private Integer cvv;
    private String balance;
    private Boolean isBlocked;
}
