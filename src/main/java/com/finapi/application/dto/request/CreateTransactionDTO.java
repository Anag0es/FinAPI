package com.finapi.application.dto.request;

import com.finapi.domain.enums.PeriodicityType;
import com.finapi.domain.enums.TransactionStatus;
import com.finapi.domain.enums.TransactionType;
import com.finapi.domain.model.BankAccount;
import com.finapi.domain.model.Card;
import com.finapi.domain.model.Tag;
import com.finapi.domain.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CreateTransactionDTO {

    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private String description;
    private PeriodicityType periodicity;
    private boolean isAvailableBalance;
    private UUID bankAccountId;
    private UUID cardId;
    private UUID userId;
    private List<UUID> tagIds;
    private TransactionStatus status;

    public CreateTransactionDTO() {}

    public CreateTransactionDTO(TransactionType type, BigDecimal amount, LocalDateTime transactionDate, String description, PeriodicityType periodicity, boolean isAvailableBalance, UUID bankAccountId, UUID cardId, UUID userId, List<UUID> tagIds, TransactionStatus status) {
        this.type = type;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
        this.periodicity = periodicity;
        this.isAvailableBalance = isAvailableBalance;
        this.bankAccountId = bankAccountId;
        this.cardId = cardId;
        this.userId = userId;
        this.tagIds = tagIds;
        this.status = status;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PeriodicityType getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(PeriodicityType periodicity) {
        this.periodicity = periodicity;
    }

    public boolean isAvailableBalance() {
        return isAvailableBalance;
    }

    public void setAvailableBalance(boolean availableBalance) {
        isAvailableBalance = availableBalance;
    }

    public UUID getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(UUID bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public UUID getCardId() {
        return cardId;
    }

    public void setCardId(UUID cardId) {
        this.cardId = cardId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<UUID> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<UUID> tagIds) {
        this.tagIds = tagIds;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
