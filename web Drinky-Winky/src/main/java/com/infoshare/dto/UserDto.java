package com.infoshare.dto;

import com.infoshare.model.User;

public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String userType;
    private String login;
    private String password;

    public static UserDto userToDto(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setUserType(user.getUserType());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static User dtoToUser(UserDto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setUserType(userDTO.getUserType());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    }

