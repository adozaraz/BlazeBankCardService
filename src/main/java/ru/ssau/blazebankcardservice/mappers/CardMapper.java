package ru.ssau.blazebankcardservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.ssau.blazebankcardservice.entities.Card;
import ru.ssau.blazebankcardservice.entities.CardDTO;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardDTO cardToCardDTO(Card card);
    Card cardDTOToCard(CardDTO cardDTO);
}
