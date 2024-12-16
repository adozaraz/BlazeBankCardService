package ru.ssau.blazebankcardservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.ssau.blazebankcardservice.entities.Card;
import ru.ssau.blazebankcardservice.entities.CardDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardDTO cardToCardDTO(Card card);

    @Mapping(target = "expirationDate", dateFormat = "yyyy-MM-dd")
    Card cardDTOToCard(CardDTO cardDTO);

    List<CardDTO> listOfCardsToCardDTO(List<Card> cards);
}
