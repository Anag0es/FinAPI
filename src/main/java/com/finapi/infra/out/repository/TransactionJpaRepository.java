package com.finapi.infra.out.repository;

import com.finapi.infra.out.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, UUID> {

    List<TransactionEntity> finByTagName(String name);

    List<TransactionEntity> findByUserId(UUID userId);
}
