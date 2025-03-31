package com.finapi.application.port.out;

import com.finapi.domain.model.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    Transaction findById(UUID id);

    List<Transaction> findAll();

    Transaction update(UUID id, Transaction transaction);

    void deleteById(UUID id);

    List<Transaction> findByUserId(UUID userId);

    List<Transaction> findByTagName(String name);

}
