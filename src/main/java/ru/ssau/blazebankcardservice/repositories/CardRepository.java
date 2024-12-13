package ru.ssau.blazebankcardservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.blazebankcardservice.entities.Card;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
    Optional<Card> findCardByUserId(Integer userId);

    Optional<Card> findCardByCardNumberAndAccountNumber(String cardNumber, String accountNumber);
}
