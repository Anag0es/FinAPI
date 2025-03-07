package com.finapi.domain.model;

import com.finapi.domain.enums.LoanStatus;
import com.finapi.domain.enums.PeriodicityType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Loan {

    private Long id;
    private PeriodicityType type;
    private BigDecimal totalAmount;
    private BigDecimal installmentAmount;
    private Date startDate;
    private Date endDate;
    private BigDecimal interestRate;
    private String description;
    private LoanStatus status;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Loan() {}

    public Loan(Long id, PeriodicityType type, BigDecimal totalAmount, BigDecimal installmentAmount, Date startDate, Date endDate, BigDecimal interestRate, String description, LoanStatus status, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.type = type;
        this.totalAmount = totalAmount;
        this.installmentAmount = installmentAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.interestRate = interestRate;
        this.description = description;
        this.status = status;
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

    public PeriodicityType getType() {
        return type;
    }

    public void setType(PeriodicityType type) {
        this.type = type;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(BigDecimal installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
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
