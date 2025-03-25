package com.finapi.application.dto.response;

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

public class ResponseTransactionDTO {

    private UUID id;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private String description;
    private PeriodicityType periodicity;
    private boolean isAvailableBalance;
    private BankAccount bankAccount;
    private Card card;
    private UUID userId;
    private List<Tag> tag;
    private TransactionStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ResponseTransactionDTO() {}

    public ResponseTransactionDTO(UUID id, TransactionType type, BigDecimal amount, LocalDateTime transactionDate, String description, PeriodicityType periodicity, boolean isAvailableBalance, BankAccount bankAccount, Card card, UUID userId, List<Tag> tag, TransactionStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
        this.periodicity = periodicity;
        this.isAvailableBalance = isAvailableBalance;
        this.bankAccount = bankAccount;
        this.card = card;
        this.userId = userId;
        this.tag = tag;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
