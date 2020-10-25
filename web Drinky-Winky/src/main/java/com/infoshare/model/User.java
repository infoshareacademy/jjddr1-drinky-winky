package com.infoshare.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
//TODO Define database tables
@Table(name ="user", schema = "users")
public class User {
    @Id
    @GeneratedValue
    private String id;
    @Column
    private String login;
//TODO should be column?
    private String password;
    @Column
    private String email;
    @OneToMany
    private List<Drink> favourites = new ArrayList<>();
    @Column
    private LocalDate birthDate;

    public User(String login, String email, List<Drink> favourites, LocalDate birthDate) {
        this.login = login;
        this.email = email;
        this.favourites = favourites;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", favourites=" + favourites +
                ", birthDate=" + birthDate +
                '}';
    }
}
