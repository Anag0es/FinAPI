package com.finapi.application.port.in.bankAccount;

import com.finapi.domain.model.BankAccount;

import java.util.List;

public interface GetBankUseCase {

    List<BankAccount> getBankAccounts();

    BankAccount getBankAccountById(Long id);
}
