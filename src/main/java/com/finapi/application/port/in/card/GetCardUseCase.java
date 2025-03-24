package com.finapi.application.port.in.card;

import com.finapi.domain.model.Card;

import java.util.List;
import java.util.UUID;

public interface GetCardUseCase {
    Card getCardById(UUID id);

    List<Card> getCards();
}

