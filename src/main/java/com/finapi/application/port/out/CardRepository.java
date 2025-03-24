package com.finapi.application.port.out;

import com.finapi.application.dto.response.ResponseCardDTO;
import com.finapi.domain.model.Card;

import java.util.List;
import java.util.UUID;

public interface CardRepository {
    Card save(Card card);

    Card findById(UUID id);

    void deleteById(UUID id);

    List<Card> findAll();

    Card updateCard(UUID cardId, Card card);

    Card findByName(String name);
}
