package com.finapi.application.port.in.transaction;

import com.finapi.application.dto.request.CreateTransactionDTO;
import com.finapi.domain.model.Transaction;

public interface CreateTransactionUseCase {

    Transaction createTransaction(CreateTransactionDTO createTransactionDTO);
}
