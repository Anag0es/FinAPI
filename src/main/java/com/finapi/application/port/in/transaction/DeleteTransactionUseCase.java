package com.finapi.application.port.in.transaction;

import java.util.UUID;

public interface DeleteTransactionUseCase {

    void deleteTransactionById(UUID id);
}
