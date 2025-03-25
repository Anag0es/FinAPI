package com.finapi.application.service;

import com.finapi.application.dto.request.CreateBankAccountDTO;
import com.finapi.application.exception.ApiException;
import com.finapi.application.port.in.bankAccount.CreateBankUseCase;
import com.finapi.application.port.in.bankAccount.DeleteBankUseCase;
import com.finapi.application.port.in.bankAccount.GetBankUseCase;
import com.finapi.application.port.in.bankAccount.UpdateBankUseCase;
import com.finapi.application.port.out.BankAccountRepository;
import com.finapi.application.port.out.TagRepository;
import com.finapi.application.port.out.UserRepository;
import com.finapi.domain.model.BankAccount;
import com.finapi.infra.out.entity.BankAccountEntity;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BankAccountService implements CreateBankUseCase, GetBankUseCase, UpdateBankUseCase, DeleteBankUseCase {

    private final BankAccountRepository bankAccountRepository;
    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository, TagRepository tagRepository, UserRepository userRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BankAccount createBankAccount(CreateBankAccountDTO createBankAccountDTO) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBank(createBankAccountDTO.getBank());
        bankAccount.setAccountNumber(createBankAccountDTO.getAccountNumber());
        bankAccount.setName(createBankAccountDTO.getName());
        bankAccount.setStatus(createBankAccountDTO.getStatus());
        bankAccount.setType(createBankAccountDTO.getType());
        bankAccount.setUser(userRepository.findById(createBankAccountDTO.getUserId()));
        bankAccount.setBranch(createBankAccountDTO.getBranch());
        bankAccount.setCurrentBalance(createBankAccountDTO.getCurrentBalance());
        bankAccount.setCreatedAt(LocalDateTime.now());
        bankAccount.setUpdatedAt(LocalDateTime.now());

        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount getBankAccountById(UUID id) {
        BankAccount bankAccount = bankAccountRepository.findById(id);
        if (bankAccount == null) {
            throw new ApiException("Conta bancária não encontrada", HttpStatus.NOT_FOUND);
        }

        return bankAccount;
    }

    @Override
    public BankAccount updateBank(UUID bankId, CreateBankAccountDTO createBankAccountDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(bankId);
        if (bankAccount == null) {
            throw new ApiException("Conta bancária não encontrada", HttpStatus.NOT_FOUND);
        }

        bankAccount.setBank(createBankAccountDTO.getBank());
        bankAccount.setAccountNumber(createBankAccountDTO.getAccountNumber());
        bankAccount.setName(createBankAccountDTO.getName());
        bankAccount.setStatus(createBankAccountDTO.getStatus());
        bankAccount.setType(createBankAccountDTO.getType());
        bankAccount.setUser(userRepository.findById(createBankAccountDTO.getUserId()));
        bankAccount.setBranch(createBankAccountDTO.getBranch());
        bankAccount.setCurrentBalance(createBankAccountDTO.getCurrentBalance());
        bankAccount.setUpdatedAt(LocalDateTime.now());

        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public void deleteBank(UUID bankId) {
        BankAccount bankAccount = bankAccountRepository.findById(bankId);
        if (bankAccount == null) {
            throw new ApiException("Conta bancária não encontrada", HttpStatus.NOT_FOUND);
        }

        bankAccountRepository.deleteById(bankId);
    }
}
