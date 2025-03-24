package com.finapi.infra.out.impl;

import com.finapi.application.port.out.TagRepository;
import com.finapi.domain.model.Tag;
import com.finapi.infra.out.entity.TagEntity;
import com.finapi.infra.out.mapper.TagMapper;
import com.finapi.infra.out.repository.TagJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TagRepositoryImpl implements TagRepository {

    @Autowired
    private TagJpaRepository tagJpaRepository;

    @Override
    public Tag save(Tag tag) {
        TagEntity tagEntity = TagMapper.toEntity(tag);
        TagEntity savedTagEntity = tagJpaRepository.save(tagEntity);

        return TagMapper.toDomain(savedTagEntity);
    }

    @Override
    public Tag findById(UUID id) {
        TagEntity tagEntity = tagJpaRepository.findById(id).orElse(null);

        return TagMapper.toDomain(tagEntity);
    }

    @Override
    public List<Tag> findAll() {
        List<TagEntity> entities = tagJpaRepository.findAll();

        return entities.stream().map(TagMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Tag findByName(String name) {
        TagEntity tagEntity = tagJpaRepository.findByName(name);

        return TagMapper.toDomain(tagEntity);
    }

    @Override
    public List<Tag> findByUserIdOrIsDefault(UUID userId, boolean isDefault) {
        List<TagEntity> tagEntity = tagJpaRepository.findByUserIdOrIsDefault(userId, isDefault);

        return tagEntity.stream().map(TagMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Tag findByNameAndUserId(String name, UUID userId) {
        TagEntity tagEntity = tagJpaRepository.findByNameAndUserId(name, userId);

        return TagMapper.toDomain(tagEntity);
    }

    @Override
    public boolean existsByNameAndIsDefault(String name, boolean isDefault) {
        return tagJpaRepository.existsByNameAndIsDefault(name, isDefault);
    }

    @Override
    public void deleteById(UUID id) {
        tagJpaRepository.deleteById(id);
    }
}
