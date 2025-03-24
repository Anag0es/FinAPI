package com.finapi.infra.out.impl;

import com.finapi.application.port.out.VerificationTokenRepository;
import com.finapi.domain.model.VerificationToken;
import com.finapi.infra.out.entity.VerificationTokenEntity;
import com.finapi.infra.out.mapper.VerificationTokenMapper;
import com.finapi.infra.out.repository.VerificationTokenJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VerificationTokenRepositoryImpl implements VerificationTokenRepository {

    @Autowired
    private VerificationTokenJpaRepository verificationTokenJpaRepository;

    @Override
    public void save(VerificationToken verificationToken) {
        VerificationTokenEntity entity = VerificationTokenMapper.toEntity(verificationToken);
        VerificationTokenEntity savedEntity = verificationTokenJpaRepository.save(entity);

        VerificationTokenMapper.toDomain(savedEntity);
    }

    @Override
    public VerificationToken findByToken(String token) {
        return verificationTokenJpaRepository.findByToken(token)
                .map(VerificationTokenMapper::toDomain)
                .orElse(null);
    }

}
