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

        //chwilowy user do testu
        User user = new User();
        user.setId(1L);
        user.setLogin("login");
        user.setPassword("pass");
        user.setName("Stefan");
        user.setSurname("Siarzewski");
        user.setUserType("Boss");
        UserDto userDTO = UserDto.userToDto(user);
        userService.saveUser(userDTO);
    }


}
