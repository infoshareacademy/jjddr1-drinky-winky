package com.infoshare.utils;

import com.infoshare.dto.UserDto;
import com.infoshare.model.User;
import com.infoshare.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class Utils {

    @Inject
    UserService userService;

    public void createRandomUserDto() {
        User admin = new User();
        admin.setId(1L);
        admin.setLogin("login");
        admin.setPassword("pass");
        admin.setName("Stefan");
        admin.setSurname("Siarzewski");
        admin.setUserType("Boss");
        UserDto adminDTO = UserDto.userToDto(admin);
        userService.saveUser(adminDTO);

        User user = new User();
        user.setId(2L);
        user.setLogin("user");
        user.setPassword("pass");
        user.setName("Jurek");
        user.setSurname("Killer");
        user.setUserType("Killer");
        UserDto userDTO = UserDto.userToDto(user);
        userService.saveUser(userDTO);
    }
}
