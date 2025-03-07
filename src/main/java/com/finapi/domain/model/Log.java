package com.finapi.domain.model;

import com.finapi.domain.enums.LogType;

import java.time.LocalDateTime;

public class Log {

    private Long id;
    private User user;
    private LogType action;
    private String entity;
    private Long entityId;
    private LocalDateTime date;
    private String ip;
    private String endpoint;

    public Log() {}

    public Log(Long id, User user, LogType action, String entity, Long entityId, LocalDateTime date, String ip, String endpoint) {
        this.id = id;
        this.user = user;
        this.action = action;
        this.entity = entity;
        this.entityId = entityId;
        this.date = date;
        this.ip = ip;
        this.endpoint = endpoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LogType getAction() {
        return action;
    }

    public void setAction(LogType action) {
        this.action = action;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
