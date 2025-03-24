package com.finapi.infra.out.impl;

import com.finapi.application.port.out.UserRepository;
import com.finapi.infra.out.mapper.UserMapper;
import com.finapi.domain.model.User;
import com.finapi.infra.out.entity.UserEntity;
import com.finapi.infra.out.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {

        UserEntity entity = UserMapper.toEntity(user);
        UserEntity savedEntity = userJpaRepository.save(entity);

        return UserMapper.toDomain(savedEntity);
    }

    @Override
    public User findByEmail(String email) {
        return Optional.ofNullable(userJpaRepository.findByEmail(email))
                .map(UserMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> entities = userJpaRepository.findAll();

        return entities.stream().map(UserMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public User findById(UUID id) {
        UserEntity entity = userJpaRepository.findById(id).orElse(null);

        return UserMapper.toDomain(entity);
    }

    @Override
    public User update(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity updatedEntity = userJpaRepository.save(entity);

        return UserMapper.toDomain(updatedEntity);
    }
}
