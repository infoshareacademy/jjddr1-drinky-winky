package com.infoshare.service;

import com.infoshare.dto.UserDTO;

import javax.inject.Inject;
import java.util.Optional;

public class LoggingService {

    @Inject
    UserService userService;

    public Optional<UserDTO> checkIfUserExist(String login) {
        return Optional.ofNullable(userService.findUserByLogin(login));
    }

    public void checkIfUserIsSigned() {

    }


}
