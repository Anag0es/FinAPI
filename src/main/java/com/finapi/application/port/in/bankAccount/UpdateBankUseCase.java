package com.finapi.application.port.in.bankAccount;

import com.finapi.application.dto.request.CreateBankAccountDTO;
import com.finapi.domain.model.BankAccount;

import java.util.UUID;

public interface UpdateBankUseCase {

    BankAccount updateBank(UUID bankId, CreateBankAccountDTO createBankAccountDTO);
}
