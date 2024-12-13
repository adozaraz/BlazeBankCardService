package ru.ssau.blazebankcardservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomingBalanceChangesDTO {
    private Integer balanceChange;
    private String cardNumber;
    private String accountNumber;
}
