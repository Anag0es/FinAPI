package com.finapi.domain.model;

import com.finapi.application.port.out.PaymentMain;
import com.finapi.domain.enums.PaymentMethodType;
import com.finapi.domain.enums.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    private Long id;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private PaymentType status;
    private PaymentMethodType paymentMethod;
    private Integer installments;
    private Integer totalInstallments;
    private PaymentMain paymentMain;

    public Payment() {}

    public Payment(Long id, BigDecimal amount, LocalDate dueDate, LocalDate paymentDate, PaymentType status, PaymentMethodType paymentMethod, Integer installments, Integer totalInstallments, PaymentMain paymentMain) {
        this.id = id;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.installments = installments;
        this.totalInstallments = totalInstallments;
        this.paymentMain = paymentMain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentType getStatus() {
        return status;
    }

    public void setStatus(PaymentType status) {
        this.status = status;
    }

    public PaymentMethodType getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public Integer getTotalInstallments() {
        return totalInstallments;
    }

    public void setTotalInstallments(Integer totalInstallments) {
        this.totalInstallments = totalInstallments;
    }

    public PaymentMain getPaymentMain() {
        return paymentMain;
    }

    public void setPaymentMain(PaymentMain paymentMain) {
        this.paymentMain = paymentMain;
    }
}
