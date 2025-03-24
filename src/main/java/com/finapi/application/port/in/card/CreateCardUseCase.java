package com.finapi.application.port.in.card;

import com.finapi.application.dto.request.CreateCardDTO;
import com.finapi.application.dto.response.ResponseCardDTO;
import com.finapi.domain.model.Card;

public interface CreateCardUseCase {
    Card createCard(CreateCardDTO createCardDTO);
}
