package ru.ssau.blazebankcardservice.entities;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardExistsDTO {
    private Boolean cardExists;
}
