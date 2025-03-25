package com.finapi.infra.out.mapper;

import com.finapi.application.dto.response.ResponseBankAccountDTO;
import com.finapi.domain.model.BankAccount;
import com.finapi.infra.out.entity.BankAccountEntity;

import java.util.List;
import java.util.stream.Collectors;

public class BankAccountMapper {

    public static BankAccount toDomain(BankAccountEntity bankAccountEntity) {
        if (bankAccountEntity == null) {
            return null;
        }

        return new BankAccount(
                bankAccountEntity.getId(),
                bankAccountEntity.getName(),
                bankAccountEntity.getType(),
                bankAccountEntity.getBank(),
                bankAccountEntity.getBranch(),
                bankAccountEntity.getAccountNumber(),
                bankAccountEntity.getCurrentBalance(),
                bankAccountEntity.getStatus(),
                UserMapper.toDomain(bankAccountEntity.getUser()),
                bankAccountEntity.getCreatedAt(),
                bankAccountEntity.getUpdatedAt()
        );
    }

    public static BankAccountEntity toEntity(BankAccount bankAccount) {
        if (bankAccount == null) {
            return null;
        }

        return new BankAccountEntity(
                bankAccount.getId(),
                bankAccount.getName(),
                bankAccount.getType(),
                bankAccount.getBank(),
                bankAccount.getBranch(),
                bankAccount.getAccountNumber(),
                bankAccount.getCurrentBalance(),
                bankAccount.getStatus(),
                UserMapper.toEntity(bankAccount.getUser()),
                bankAccount.getCreatedAt(),
                bankAccount.getUpdatedAt()
        );
    }

    public static ResponseBankAccountDTO toDTO(BankAccount bankAccount) {
        if (bankAccount == null) return null;

        return new ResponseBankAccountDTO(
                bankAccount.getName(),
                bankAccount.getType(),
                bankAccount.getBank(),
                bankAccount.getBranch(),
                bankAccount.getAccountNumber(),
                bankAccount.getCurrentBalance(),
                bankAccount.getStatus(),
                bankAccount.getUser().getId()
        );
    }

    public static List<ResponseBankAccountDTO> toDTOList(List<BankAccount> bankAccount) {
        return bankAccount.stream()
                .map(BankAccountMapper::toDTO)
                .collect(Collectors.toList());
    }
}
