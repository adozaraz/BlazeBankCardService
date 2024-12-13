package ru.ssau.blazebankcardservice.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SuccessResponse {
    private String msg;
}
