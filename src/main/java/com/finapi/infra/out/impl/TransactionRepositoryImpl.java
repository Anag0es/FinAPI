package com.finapi.infra.out.impl;

import com.finapi.application.port.out.TransactionRepository;
import com.finapi.domain.model.Transaction;
import com.finapi.infra.out.repository.TransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private TransactionJpaRepository transactionJpaRepository;

    @Override
    public Transaction save(Transaction transaction) {
        ret
    }
}
