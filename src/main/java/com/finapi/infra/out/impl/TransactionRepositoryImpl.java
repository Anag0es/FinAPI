package com.finapi.infra.out.impl;

import com.finapi.application.port.out.TransactionRepository;
import com.finapi.domain.model.Transaction;
import com.finapi.infra.out.entity.TransactionEntity;
import com.finapi.infra.out.mapper.TransactionMapper;
import com.finapi.infra.out.repository.TransactionJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private TransactionJpaRepository transactionJpaRepository;

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity transactionEntity = TransactionMapper.toEntity(transaction);
        TransactionEntity savedTransactionEntity = transactionJpaRepository.save(transactionEntity);

        return TransactionMapper.toDomain(savedTransactionEntity);
    }

    @Override
    public Transaction findById(UUID id) {
        TransactionEntity transactionEntity = transactionJpaRepository.findById(id).orElse(null);

        return TransactionMapper.toDomain(transactionEntity);
    }

    @Override
    public List<Transaction> findAll() {
        List<TransactionEntity> entities = transactionJpaRepository.findAll();

        return entities.stream().map(TransactionMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Transaction update(UUID id, Transaction transaction) {
        TransactionEntity transactionEntity = TransactionMapper.toEntity(transaction);
        TransactionEntity updatedTransactionEntity = transactionJpaRepository.save(transactionEntity);

        return TransactionMapper.toDomain(updatedTransactionEntity);
    }

    @Override
    public void deleteById(UUID id) {
        transactionJpaRepository.deleteById(id);
    }
}
