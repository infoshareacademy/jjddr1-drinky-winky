package com.infoshare.service;

import com.infoshare.dao.UserDao;
import com.infoshare.dto.UserDTO;
import com.infoshare.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;


@RequestScoped
public class UserService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private UserDao userDao;

    @Transactional
    public void saveUser(UserDTO userDTO) {
        if (userDao.getUserList().stream().noneMatch(user -> user.getName().equals(userDTO.getName()))) {
            User user = UserDTO.dtoToUser(userDTO);
            userDao.saveUser(user);
        }
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
    public List<User> getUserByLoginAndPass(String login, String password) {

        return userDao.getUserByLoginAndPass(login, password);
    }

    public UserDTO getUserByLogin(String login) {
        User user = userDao.getUserByLogin(login);
        return UserDTO.userToDto(user);
    }
}