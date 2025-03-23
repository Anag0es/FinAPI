package com.finapi.application.dto;

import com.finapi.domain.enums.Roles;
import com.finapi.domain.enums.Status;

public class ResponseUserDTO {

    private Long id;
    private String name;
    private String email;
    private Roles role;
    private Status status;
    private String lastLogin;

    public ResponseUserDTO() {}

    public ResponseUserDTO(Long id, String name, String email, Roles role, Status status, String lastLogin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.status = status;
        this.lastLogin = lastLogin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
}
