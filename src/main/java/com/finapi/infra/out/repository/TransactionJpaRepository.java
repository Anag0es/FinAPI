package com.finapi.infra.out.repository;

import com.finapi.infra.out.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, UUID> {

    TransactionEntity finByTagName(String name);
}
