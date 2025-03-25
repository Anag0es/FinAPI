package com.finapi.infra.out.impl;

import com.finapi.application.port.out.BankAccountRepository;
import com.finapi.domain.model.BankAccount;
import com.finapi.infra.out.entity.BankAccountEntity;
import com.finapi.infra.out.mapper.BankAccountMapper;
import com.finapi.infra.out.repository.BankAccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankAccountRepositoryImpl implements BankAccountRepository {

    @Autowired
    private BankAccountJpaRepository bankAccountJpaRepository;

    @Override
    public BankAccount save(BankAccount bankAccount) {
        BankAccountEntity bankAccountEntity = BankAccountMapper.toEntity(bankAccount);
        BankAccountEntity savedBankAccountEntity = bankAccountJpaRepository.save(bankAccountEntity);

        return BankAccountMapper.toDomain(savedBankAccountEntity);
    }

    @Override
    public BankAccount findById(UUID id) {
        BankAccountEntity bankAccountEntity = bankAccountJpaRepository.findById(id).orElse(null);

        return BankAccountMapper.toDomain(bankAccountEntity);
    }

    @Override
    public List<BankAccount> findAll() {
        List<BankAccountEntity> entities = bankAccountJpaRepository.findAll();

        return entities.stream().map(BankAccountMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        bankAccountJpaRepository.deleteById(id);
    }
}
