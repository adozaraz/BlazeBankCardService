package ru.ssau.blazebankcardservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private UUID userId;

    private String cardNumber;

    private String accountNumber;

    private Date expirationDate;

    private String cardType;

    private String walletType;

    private Integer cvv;

    private BigInteger balance;

    private Boolean isBlocked;
}
