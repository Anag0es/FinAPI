package com.finapi.application.port.in.transaction;

import com.finapi.domain.model.Transaction;

import java.util.List;

public interface GetTransactionUseCase {

    List<Transaction> getTransactions();

    Transaction getTransactionById(Long id);

    List<Transaction> getTransactionsForUser(Long userId);

    List<Transaction> getTransactionsForTag(Long tagId);
}
