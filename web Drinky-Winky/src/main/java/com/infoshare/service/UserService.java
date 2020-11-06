package com.infoshare.service;

import com.infoshare.dao.UserDao;
import com.infoshare.dto.DrinkDTO;
import com.infoshare.dto.UserDTO;
import com.infoshare.model.Drink;
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
    public void saveFavDrink(Long drinkId, Long userId){
        userDao.addFav(drinkId,userId);
    }

    @Transactional
    public void saveUser(UserDTO userDTO) {
        User user = UserDTO.dtoToUser(userDTO);
        userDao.saveUser(user);
    }

    public void updateUser(UserDTO userDTO) {
        userDao.updateUser(UserDTO.dtoToUser(userDTO));
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
    public List<Drink> getFavouriteList() {
        return userDao.getFavouriteDrinkList();
    }


}
