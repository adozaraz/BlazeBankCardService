package ru.ssau.blazebankcardservice.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CardDTO {
    private Integer id;
    private Integer userId;
    private String cardNumber;
    private String accountNumber;
    private String expirationDate;
    private String cardType;
    private String walletType;
    private Integer cvv;
    private String balance;
    private Boolean isBlocked;

    @Override
    public String toString() {
        return "CardDTO{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cardType='" + cardType + '\'' +
                ", walletType='" + walletType + '\'' +
                ", cvv=" + cvv +
                ", balance='" + balance + '\'' +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
