package com.infoshare.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = User.FIND_USER_BY_NAME,
                query = "SELECT distinct u FROM User u WHERE u.name like :name"),
        @NamedQuery(
                name = User.FIND_USER_BY_LOGIN,
                query = "SELECT distinct u FROM User u WHERE u.login like :login"),
        @NamedQuery(
                name = User.FIND_USER_LIST,
                query = "SELECT u FROM User u"),
        @NamedQuery(
                name = User.GET_USER_BY_LOGIN,
                query = "SELECT u FROM User u WHERE u.login LIKE :login"),
        @NamedQuery(
                name = User.GET_USER_BY_PASSWORD,
                query = "SELECT p FROM User p WHERE p.password LIKE :password"),
        @NamedQuery(
                name = User.GET_LOGIN_AND_PASSWORD,
                query = "SELECT u.login, u.password FROM User u WHERE u.login LIKE :login AND u.password LIKE :password"),
        @NamedQuery(
                name = User.GET_FAVOURITE_LIST,
                query = "SELECT u.favouriteDrinkList FROM User u JOIN u.favouriteDrinkList r WHERE r.id=u.id")
})

@Entity
@Data
public class User {

    public static final String FIND_USER_BY_NAME = "User.findUserByName";
    public static final String FIND_USER_BY_LOGIN = "User.findUserByLogin";
    public static final String FIND_USER_LIST = "User.getUserList";
    public static final String GET_FAVOURITE_LIST = "User.getFavouritesList";
    public static final String GET_USER_BY_LOGIN = "User.getUserByLogin";
    public static final String GET_USER_BY_PASSWORD = "User.getUserByPassword";
    public static final String GET_LOGIN_AND_PASSWORD = "User.getLoginAndPassword";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String userType;

    @Column( unique = true)
    private String login;

    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_favourite_drink",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "drink_id", referencedColumnName = "id")}
    )
    private List<Drink> favouriteDrinkList = new ArrayList<>();
}
