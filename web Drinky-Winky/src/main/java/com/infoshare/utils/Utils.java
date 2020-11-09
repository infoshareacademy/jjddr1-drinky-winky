package com.infoshare.utils;

import com.infoshare.dto.UserDTO;
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
        user.setId(1l);
        user.setLogin("login");
        user.setPassword("pass");
        user.setName("Stefan");
        user.setSurname("Siara");
        user.setUserType("Boss");
        UserDTO userDTO = UserDTO.userToDto(user);
        userService.saveUser(userDTO);
    }


}
