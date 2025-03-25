package com.finapi.infra.out.repository;

import com.finapi.domain.model.Tag;
import com.finapi.infra.out.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TagJpaRepository extends JpaRepository<TagEntity, UUID> {

    TagEntity findByName(String name);

    List<TagEntity> findByUserIdOrIsDefault(UUID userId, boolean isDefault);

    TagEntity findByNameAndUserId(String name, UUID userId);

    boolean existsByNameAndIsDefault(String name, boolean isDefault);
}
