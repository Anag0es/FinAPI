package com.finapi.infra.out.mapper;

import com.finapi.application.dto.response.ResponseTransactionDTO;
import com.finapi.domain.model.Tag;
import com.finapi.domain.model.Transaction;
import com.finapi.infra.out.entity.TransactionEntity;

import java.util.List;
import java.util.stream.Collectors;


public class TransactionMapper {

    public static Transaction toDomain(TransactionEntity transactionEntity) {
        if (transactionEntity == null) {
            return null;
        }

        return new Transaction(
                transactionEntity.getId(),
                transactionEntity.getType(),
                transactionEntity.getAmount(),
                transactionEntity.getTransactionDate(),
                transactionEntity.getDescription(),
                transactionEntity.getPeriodicity(),
                transactionEntity.isAvailableBalance(),
                transactionEntity.getBankAccount(),
                transactionEntity.getCard(),
                transactionEntity.getUser(),
                transactionEntity.getStatus(),
                transactionEntity.getTag(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getUpdatedAt()
        );
    }

    public static TransactionEntity toEntity(Transaction transaction) {
        if (transaction == null) {
            return null;
        }

        return new TransactionEntity(
                transaction.getId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getTransactionDate(),
                transaction.getDescription(),
                transaction.getPeriodicity(),
                transaction.isAvailableBalance(),
                transaction.getBankAccount(),
                transaction.getCard(),
                transaction.getUser(),
                transaction.getStatus(),
                transaction.getTag(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public static ResponseTransactionDTO toDTO(Transaction transaction) {
        if (transaction == null) return null;

        return new ResponseTransactionDTO(
                transaction.getId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getTransactionDate(),
                transaction.getDescription(),
                transaction.getPeriodicity(),
                transaction.isAvailableBalance(),
                transaction.getBankAccount() != null ? transaction.getBankAccount() : null,
                transaction.getCard() != null ? transaction.getCard() : null,
                transaction.getUser() != null ? transaction.getUser().getId() : null,
                transaction.getTag() != null ? transaction.getTag() : null,
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public static List<ResponseTransactionDTO> toDTOList(List<Transaction> transactions) {
        return transactions.stream()
                .map(TransactionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
