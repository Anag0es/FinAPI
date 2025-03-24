package com.finapi.infra.out.mapper;

import com.finapi.domain.model.VerificationToken;
import com.finapi.infra.out.entity.VerificationTokenEntity;

public class VerificationTokenMapper {

    public static VerificationTokenEntity toEntity(VerificationToken domain) {
        if (domain == null) return null;

        VerificationTokenEntity entity = new VerificationTokenEntity();
        entity.setId(domain.getId());
        entity.setToken(domain.getToken());
        entity.setUserId(domain.getUserId());
        entity.setTokenType(domain.getTokenType());
        entity.setNewValue(domain.getNewValue());
        entity.setExpiryDate(domain.getExpiryDate());
        entity.setUsed(domain.isUsed());

        return entity;
    }

    public static VerificationToken toDomain(VerificationTokenEntity entity) {
        if (entity == null) return null;

        VerificationToken domain = new VerificationToken();
        domain.setId(entity.getId());
        domain.setToken(entity.getToken());
        domain.setUserId(entity.getUserId());
        domain.setTokenType(entity.getTokenType());
        domain.setNewValue(entity.getNewValue());
        domain.setExpiryDate(entity.getExpiryDate());
        domain.setUsed(entity.isUsed());

        return domain;
    }
}