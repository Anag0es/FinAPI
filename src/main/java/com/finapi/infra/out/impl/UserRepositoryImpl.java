package com.finapi.infra.out.impl;

import com.finapi.application.mapper.UserMapper;
import com.finapi.domain.model.User;
import com.finapi.domain.repository.UserRepository;
import com.finapi.infra.out.entity.UserEntity;
import com.finapi.infra.out.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
