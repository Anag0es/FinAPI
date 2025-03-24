package com.finapi.application.dto.request;

import com.finapi.domain.model.User;

import java.util.UUID;

public class CreateTagDTO {

    private String name;
    private UUID userId;

    public CreateTagDTO() {
    }

    public CreateTagDTO(String name, UUID userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUser() {
        return userId;
    }

    public void setUser(UUID userId) {
        this.userId = userId;
    }
}
