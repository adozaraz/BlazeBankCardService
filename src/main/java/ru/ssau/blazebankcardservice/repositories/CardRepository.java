package ru.ssau.blazebankcardservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ssau.blazebankcardservice.entities.Card;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardRepository extends CrudRepository<Card, UUID> {
    Optional<Card> findCardByUserId(UUID userId);
}
