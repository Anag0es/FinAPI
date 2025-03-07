package com.finapi.domain.model;

import com.finapi.domain.enums.PeriodicityType;
import com.finapi.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
