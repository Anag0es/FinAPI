package com.finapi.infra.out.repository;


import com.finapi.infra.out.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardJpaRepository extends JpaRepository<CardEntity, UUID> {

    CardEntity findByName(String name);
}
