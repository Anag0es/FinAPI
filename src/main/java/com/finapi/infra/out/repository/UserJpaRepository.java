package com.finapi.infra.out.repository;

import com.finapi.infra.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByEmail(String email);
}
