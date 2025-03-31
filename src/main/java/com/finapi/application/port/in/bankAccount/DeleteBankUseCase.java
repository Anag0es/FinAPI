package com.finapi.application.port.in.bankAccount;

import java.util.UUID;

public interface DeleteBankUseCase {

    void deleteBank(UUID bankId);
}
