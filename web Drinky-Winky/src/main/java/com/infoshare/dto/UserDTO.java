package com.infoshare.dto;


import com.infoshare.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UserDTO {

    private Long id;
    private String name;
    private String surname;
    private String userType;
    private String login;
    private String password;
    private String email;
    private List<DrinkDTO> drinkDTOS = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String surname, String userType, String login, String password, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.userType = userType;
        this.login = login;
        this.password = password;
        this.email = email;
    }



    public static Function<UserDTO, User> DtoToUser = new Function<UserDTO, User>() {
        @Override
        public User apply(UserDTO userDTO) {
            return new User(userDTO.getId(),userDTO.getName(), userDTO.getSurname(), userDTO.getUserType(), userDTO.getLogin(),
                            userDTO.getPassword(),userDTO.getEmail());
        }
    };

    public static Function<User, UserDTO> UserToDto = new Function<User, UserDTO>() {
        @Override
        public UserDTO apply(User user) {
            return new UserDTO(user.getName(), user.getSurname(), user.getUserType(), user.getLogin(),
                                user.getPassword(), user.getEmail());
        }
    };

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
