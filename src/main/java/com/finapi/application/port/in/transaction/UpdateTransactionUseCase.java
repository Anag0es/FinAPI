package com.finapi.application.port.in.transaction;

import com.finapi.application.dto.request.CreateTransactionDTO;
import com.finapi.domain.model.Transaction;

import java.util.UUID;

public interface UpdateTransactionUseCase {

    Transaction updateTransaction(UUID transactionId, CreateTransactionDTO transactionDTO);
}
