package com.finapi.application.port.in.card;

import java.util.UUID;

public interface DeleteCardUseCase {
    void deleteCardById(UUID id);
}
