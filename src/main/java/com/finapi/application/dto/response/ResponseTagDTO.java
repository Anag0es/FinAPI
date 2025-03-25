package com.finapi.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class ResponseTagDTO {
    private UUID id;
    private String name;
    private boolean isDefault;
    private UUID userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public ResponseTagDTO() {}

    public ResponseTagDTO(UUID id, String name, boolean isDefault, UUID userId,
                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.isDefault = isDefault;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isDefault() { return isDefault; }
    public void setDefault(boolean isDefault) { this.isDefault = isDefault; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}