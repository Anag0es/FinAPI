package com.finapi.infra.out.repository;

import com.finapi.infra.out.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountJpaRepository extends JpaRepository<BankAccountEntity, UUID> {
}
