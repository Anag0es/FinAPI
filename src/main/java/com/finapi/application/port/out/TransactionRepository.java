package com.finapi.application.port.out;

import com.finapi.domain.model.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    Transaction findById(Long id);

    List<Transaction> findAll();

    Transaction update(UUID id, Transaction transaction);

    void deleteById(Long id);
}
