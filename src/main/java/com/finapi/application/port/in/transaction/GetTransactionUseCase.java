package com.finapi.application.port.in.transaction;

import com.finapi.domain.model.Transaction;

import java.util.List;
import java.util.UUID;

public interface GetTransactionUseCase {

    List<Transaction> getTransactions();

    Transaction getTransactionById(UUID id);

    List<Transaction> getTransactionsForUser(UUID userId);

    List<Transaction> getTransactionsForTag(String name);
}
