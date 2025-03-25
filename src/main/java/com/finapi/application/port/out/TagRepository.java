package com.finapi.application.port.out;

import com.finapi.domain.model.Tag;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.UUID;

public interface TagRepository {
    Tag save(Tag tag);

    Tag findById(UUID id);

    List<Tag> findAll();

    void deleteById(UUID id);

    Tag findByName(String name);

    List<Tag> findByUserIdOrIsDefault(UUID userId, boolean isDefault);

    Tag findByNameAndUserId(String name, UUID userId);

    boolean existsByNameAndIsDefault(String name, boolean isDefault);

    List<Tag> findByIds(List<UUID> tagIds);
}
