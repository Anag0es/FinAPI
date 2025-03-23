package com.finapi.infra.out.impl;

import com.finapi.application.exception.ApiException;
import com.finapi.application.mapper.UserMapper;
import com.finapi.domain.model.User;
import com.finapi.domain.repository.UserRepository;
import com.finapi.infra.out.entity.UserEntity;
import com.finapi.infra.out.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
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
        UserEntity entity = userJpaRepository.findByEmail(email);
        if (entity == null) {
            return null;
        }
        return UserMapper.toDomain(entity);
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
}
