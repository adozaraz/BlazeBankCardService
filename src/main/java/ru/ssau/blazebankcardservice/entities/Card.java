package ru.ssau.blazebankcardservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    private String cardNumber;

    private String accountNumber;

    private Date expirationDate;

    private String cardType;

    private String walletType;

    private Integer cvv;

    private BigInteger balance;

    private Boolean isBlocked;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", userId=" + userId +
                ", cardNumber='" + cardNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", expirationDate=" + expirationDate +
                ", cardType='" + cardType + '\'' +
                ", walletType='" + walletType + '\'' +
                ", cvv=" + cvv +
                ", balance=" + balance +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
