package com.finapi.application.port.out;

import com.finapi.domain.model.BankAccount;

import java.util.List;
import java.util.UUID;

public interface BankAccountRepository {

    BankAccount save(BankAccount bankAccount);

    BankAccount findById(UUID id);

    List<BankAccount> findAll();

    void deleteById(UUID id);
}
