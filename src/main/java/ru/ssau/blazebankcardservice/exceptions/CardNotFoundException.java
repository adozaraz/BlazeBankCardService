package ru.ssau.blazebankcardservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardNotFoundException extends RuntimeException {
    private String message;
}
