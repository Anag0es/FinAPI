package com.finapi.infra.out.entity;

import com.finapi.domain.enums.PeriodicityType;
import com.finapi.domain.enums.TransactionStatus;
import com.finapi.domain.enums.TransactionType;
import com.finapi.domain.model.BankAccount;
import com.finapi.domain.model.Card;
import com.finapi.domain.model.Tag;
import com.finapi.domain.model.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private BigDecimal amount;

    private LocalDateTime transactionDate;

    private String description;

    @Enumerated(EnumType.STRING)
    private PeriodicityType periodicity;

    private boolean isAvailableBalance;

    @ManyToOne
    private BankAccount bankAccount;

    @ManyToOne
    private Card card;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "transaction_tags",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tag;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Transaction() {
    }

    public Transaction(UUID id, TransactionType type, BigDecimal amount, LocalDateTime transactionDate, String description, PeriodicityType periodicity, boolean isAvailableBalance, BankAccount bankAccount, Card card, User user, TransactionStatus status, List<Tag> tag, LocalDateTime createdAt, LocalDateTime updatedAt) {
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
        this.status = status;
        this.tag = tag;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
