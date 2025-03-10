package com.finapi.domain.repository;

import com.finapi.domain.model.User;

public interface UserRepository {

    User save(User user);

    User findByEmail(String email);

}
