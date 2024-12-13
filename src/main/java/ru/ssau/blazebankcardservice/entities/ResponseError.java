package ru.ssau.blazebankcardservice.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
    private int statusCode;
    private String message;
}
