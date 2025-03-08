package com.finapi.infra.in;

import com.finapi.application.dto.CreateUserDTO;
import com.finapi.application.service.UserService;
import com.finapi.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody CreateUserDTO createUserDTO) {
        User newUser = userService.createUser(createUserDTO);
        return newUser;
    }
}
