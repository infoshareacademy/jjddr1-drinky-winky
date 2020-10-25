package com.infoshare.dto;

import com.infoshare.model.Drink;
import com.infoshare.model.User;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UserDTO {

    private String login;

    private String email;

    private List<Drink> favourites = new ArrayList<>();

    private LocalDate birthDate;

    public UserDTO() {
    }

    public static Function<UserDTO, User> dtoToUser = new Function<UserDTO, User>() {
        @Override
        public User apply(UserDTO userDto) {
            return new User(userDto.getLogin(), userDto.getEmail(), userDto.getFavourites(), userDto.getBirthDate());
        }
    };

    public static Function<User, UserDTO> userToDto = new Function<User, UserDTO>() {
        @Override
        public UserDTO apply(User user) {
            return new UserDTO(user.getLogin(), user.getEmail(), user.getFavourites(), user.getBirthDate());
        }
    };

    public UserDTO(String login, String email, List<Drink> favourites, LocalDate birthDate) {
        this.login = login;
        this.email = email;
        this.favourites = favourites;
        this.birthDate = birthDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Drink> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Drink> favourites) {
        this.favourites = favourites;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
