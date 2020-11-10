package com.infoshare.service;

import com.infoshare.dto.UserDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Optional;

@RequestScoped
public class LoggingService {

    @Inject
    UserService userService;

    public Optional<UserDTO> checkUser(String login) {
        return userService.findUserByLogin(login);
    }

    public boolean checkPassword(UserDTO userDTO, String password) {
        return userDTO.getPassword().equals(password);
    }

    public void checkIfUserIsSigned() {

    }


}
