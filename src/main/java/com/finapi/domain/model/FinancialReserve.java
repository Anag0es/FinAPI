package com.finapi.domain.model;

import com.finapi.domain.enums.ReservesType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class FinancialReserve {

    private Long id;
    private String name;
    private ReservesType type;
    private BigDecimal initialAmount;
    private BigDecimal currentAmount;
    private BigDecimal rate;
    private Date startDate;
    private String description;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public FinancialReserve() {}

    public FinancialReserve(Long id, String name, ReservesType type, BigDecimal initialAmount, BigDecimal currentAmount, BigDecimal rate, Date startDate, String description, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.initialAmount = initialAmount;
        this.currentAmount = currentAmount;
        this.rate = rate;
        this.startDate = startDate;
        this.description = description;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReservesType getType() {
        return type;
    }

    public void setType(ReservesType type) {
        this.type = type;
    }

    public BigDecimal getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.initialAmount = initialAmount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
