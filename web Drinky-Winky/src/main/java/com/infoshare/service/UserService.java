package com.infoshare.service;

import com.infoshare.dao.UserDao;
import com.infoshare.dto.UserDTO;
import com.infoshare.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.Optional;


@RequestScoped
public class UserService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private UserDao userDao;

    @Transactional
    public void saveFavDrink(Long drinkId, Long userId) {
        userDao.addFav(drinkId, userId);
    }

    @Transactional
    public Boolean saveUser(UserDTO userDTO) {
        if (userDao.getUserList().stream().noneMatch(user -> user.getLogin().equals(userDTO.getLogin()))) {
            User user = UserDTO.dtoToUser(userDTO);
            user.setUserType("custom");
            userDao.saveUser(user);
        }
        return false;
    }

    public void updateUser(UserDTO userDTO, Long id) {
        userDao.updateUser(UserDTO.dtoToUser(userDTO), id);
    }

    @Transactional
    public UserDTO getUserById(Long id) {
        User userByID = userDao.getUserById(id);
        if (userByID != null) {
            return UserDTO.userToDto(userByID);
        }
        return null;
    }

    @Transactional
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    //TODO change to DTO
//    public List<DrinkDTO> getFavouriteList() {
//        List<Drink> favouriteDrinkList = userDao.getFavouriteDrinkList();
//        return DrinkDTO.drinkToDTO(favouriteDrinkList);

    //    }

    public Boolean isFavourite(String drinkName, Long id) {
        return userDao.isFavourite(drinkName, id);
    }

    public UserDTO getUserByLoginAndPass(String login, String password) {
        User userByLoginAndPass = userDao.getUserByLoginAndPass(login, password);
        return UserDTO.userToDto(userByLoginAndPass);
    }

    @Transactional
    public Optional<UserDTO> findUserByLogin(String login) {
        if (userDao.findUserByLogin(login).isPresent()) {
            return Optional.of(UserDTO.userToDto(userDao.findUserByLogin(login).orElseThrow()));
        }
        return Optional.empty();
    }


    public UserDTO getUserLogin(String login) {
        if (userDao.getUserList().stream().anyMatch(user -> user.getLogin().equals(login))) {
            User user = userDao.getLogin(login);
            return UserDTO.userToDto(user);
        }
        return null;
    }

    public UserDTO getUserPassword(String password) {
        if (userDao.getUserList().stream().anyMatch(user -> user.getPassword().equals(password))) {
            User user = userDao.getPassword(password);
            return UserDTO.userToDto(user);
        }
        return null;

    }
}