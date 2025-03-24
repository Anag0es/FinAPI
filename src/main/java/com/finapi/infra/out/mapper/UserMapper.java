package com.finapi.infra.out.mapper;

import com.finapi.domain.model.User;
import com.finapi.infra.out.entity.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole(),
                entity.getStatus(),
                entity.getLastLogin(),
                entity.getResetToken(),
                entity.getResetTokenExpiration(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }

        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getStatus(),
                user.getLastLogin(),
                user.getResetToken(),
                user.getResetTokenExpiration(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}