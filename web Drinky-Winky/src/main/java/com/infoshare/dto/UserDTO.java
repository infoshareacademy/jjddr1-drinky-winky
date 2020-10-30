package com.infoshare.dto;


import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String surname;
    private String userType;
    private String login;
    private String password;
    private String email;
    private List<DrinkDTO> drinkDTOS = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<DrinkDTO> getDrinkDTOS() {
        return drinkDTOS;
    }

    public void setDrinkDTOS(List<DrinkDTO> drinkDTOS) {
        this.drinkDTOS = drinkDTOS;
    }
}
