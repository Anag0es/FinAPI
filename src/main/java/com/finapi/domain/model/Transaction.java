package com.finapi.domain.model;

import com.finapi.domain.enums.PeriodicityType;
import com.finapi.domain.enums.TransactionType;
import com.finapi.domain.repository.PaymentMain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction implements PaymentMain {

    private Long id;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private String description;
    private PeriodicityType periodicity;
    private boolean isAvailableBalance;
    private BankAccount bankAccount;
    private Card card;
    private User user;
    private Tag tag;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Transaction() {}

    public Transaction(Long id, TransactionType type, BigDecimal amount, LocalDateTime transactionDate, String description, PeriodicityType periodicity, boolean isAvailableBalance, BankAccount bankAccount, Card card, User user, Tag tag, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
        this.periodicity = periodicity;
        this.isAvailableBalance = isAvailableBalance;
        this.bankAccount = bankAccount;
        this.card = card;
        this.user = user;
        this.tag = tag;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
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
