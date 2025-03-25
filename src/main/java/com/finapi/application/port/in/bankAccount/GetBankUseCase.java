package com.finapi.application.port.in.bankAccount;

import com.finapi.domain.model.BankAccount;

import java.util.List;
import java.util.UUID;

public interface GetBankUseCase {

    List<BankAccount> getBankAccounts();

    BankAccount getBankAccountById(UUID id);
}
