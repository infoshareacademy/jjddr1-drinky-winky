package com.infoshare.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = User.FIND_USER_BY_NAME ,
                query = "SELECT distinct u FROM User u WHERE u.name like :name"),
        @NamedQuery(
                name = User.FIND_USER_LIST,
                query = "SELECT u FROM User u"),
        @NamedQuery(
                name = User.GET_USER_BY_LOGIN,
                query = "SELECT distinct r FROM User r WHERE r.login LIKE :login"),
        @NamedQuery(
                name = User.GET_USER_BY_PASSWORD,
                query = "SELECT p FROM User p WHERE p.password LIKE :password"),
        @NamedQuery(
                name = User.GET_USER_BY_LOGIN_AND_PASSWORD,
                query = "SELECT u.login, u.password FROM User u WHERE u.login LIKE :login AND u.password LIKE :password"
        )
})


//        @NamedQuery(
//                name = User.GET_FAVOURITE_LIST,
//                query = "SELECT u.favouriteDrinkList FROM User u JOIN u.favouriteDrinkList r WHERE r.id=u.id")
@Entity
@Table(name = "user")
public class User {

    public static final String FIND_USER_BY_NAME = "User.findUserByName";
    public static final String FIND_USER_LIST = "User.getUserList";
    public static final String GET_FAVOURITE_LIST = "User.getFavouritesList";
    public static final String GET_USER_BY_LOGIN = "User.getUserByLogin";
    public static final String GET_USER_BY_PASSWORD = "User.getUserByPassword";
    public static final String GET_USER_BY_LOGIN_AND_PASSWORD = "User.getUserByLoginAndPassword";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
//    @NotNull
    private String name;

    @Column(name = "surname")
//    @NotNull
    private String surname;

    @Column(name = "user_type")
//    @NotNull
    private String userType;

    @Column(name = "login", unique = true)
//    @NotNull
    private String login;

    @Column(name = "password")
//    @NotNull
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_favourite_drink",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "drink_id", referencedColumnName = "id")}
    )
    private List<Drink> favouriteDrinkList = new ArrayList<>();

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

    public List<Drink> getFavouriteDrinkList() {
        return favouriteDrinkList;
    }

    public void setFavouriteDrinkList(List<Drink> favouriteDrinkList) {
        this.favouriteDrinkList = favouriteDrinkList;
    }
}
