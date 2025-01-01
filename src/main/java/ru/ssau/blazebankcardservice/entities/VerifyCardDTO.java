package ru.ssau.blazebankcardservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerifyCardDTO {
    private String cardNumber;
    private Integer cvv;
}
