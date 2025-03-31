package com.finapi.application.port.in.bankAccount;

import com.finapi.application.dto.request.CreateBankAccountDTO;
import com.finapi.domain.model.BankAccount;

public interface CreateBankUseCase {

    BankAccount createBankAccount(CreateBankAccountDTO createBankAccountDTO);
}
