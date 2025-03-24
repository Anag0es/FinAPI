package com.finapi.application.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.finapi.domain.enums.CardType;
import com.finapi.domain.enums.Status;
import com.finapi.domain.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CreateCardDTO {

    private String name;
    private CardType type;
    private String number;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiration;
    private BigDecimal limitAmount;
    private String band;
    private UUID userId;
    private Status status;

    public CreateCardDTO() {}

    public CreateCardDTO(String name, CardType type, String number, LocalDateTime expiration, BigDecimal limitAmount, String band, UUID userId, Status status) {
        this.name = name;
        this.type = type;
        this.number = number;
        this.expiration = expiration;
        this.limitAmount = limitAmount;
        this.band = band;
        this.userId = userId;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public UUID getUser() {
        return userId;
    }

    public void setUser(UUID userId) {
        this.userId = userId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
