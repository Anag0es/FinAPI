package com.finapi.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class VerificationToken {

    private UUID id;
    private UUID userId;
    private String token;
    private String tokenType;
    private String newValue;
    private LocalDateTime expiryDate;
    private boolean used;

    public VerificationToken() {}

    public VerificationToken(UUID id, UUID userId, String token, String tokenType, String newValue, LocalDateTime expiryDate, boolean used) {
        this.id = id;
        this.userId = userId;
        this.token = token;
        this.tokenType = tokenType;
        this.newValue = newValue;
        this.expiryDate = expiryDate;
        this.used = used;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
