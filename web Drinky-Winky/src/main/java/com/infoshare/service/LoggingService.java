package com.infoshare.service;

import com.infoshare.dto.UserDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Optional;

@RequestScoped
public class LoggingService {

    @Inject
    UserService userService;

    public Optional<UserDto> checkUser(String login) {
        return userService.findUserByLogin(login);
    }

    public boolean checkPassword(UserDto userDTO, String password) {
        return userDTO.getPassword().equals(password);
    }

    public void checkIfUserIsSigned() {

    }


}
