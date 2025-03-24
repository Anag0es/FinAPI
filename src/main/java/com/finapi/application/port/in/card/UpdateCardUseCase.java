package com.finapi.application.port.in.card;

import com.finapi.application.dto.request.CreateCardDTO;
import com.finapi.domain.model.Card;

import java.util.UUID;

public interface UpdateCardUseCase {

    Card updateCard(UUID cardId, CreateCardDTO cardDTO);
}
