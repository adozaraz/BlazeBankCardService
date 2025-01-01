package ru.ssau.blazebankcardservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.blazebankcardservice.entities.Card;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
    Optional<Card> findCardByUserId(String userId);

    Optional<Card> findCardByCardNumberAndAccountNumber(String cardNumber, String accountNumber);

    Optional<Card> findCardByCardNumber(String cardNumber);

    List<Card> findAllByUserId(String userId);
}
