package com.finapi.application.dto.request;

import com.finapi.domain.enums.Status;
import com.finapi.domain.model.User;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateBankAccountDTO {

    private String name;
    private String type;
    private String bank;
    private String branch;
    private String accountNumber;
    private BigDecimal currentBalance;
    private Status status;
    private UUID userId;

    public CreateBankAccountDTO() {}

    public CreateBankAccountDTO(String name, String type, String bank, String branch, String accountNumber, BigDecimal currentBalance, Status status, UUID userId) {
        this.name = name;
        this.type = type;
        this.bank = bank;
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.status = status;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
