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
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@RequestScoped
public class UserService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private UserDao userDao;

    public void saveFavDrink(Long drinkId, Long userId) {
        userDao.addFav(drinkId, userId);
    }

    public Boolean saveUser(UserDTO userDTO) {
        if (userDao.getUserList().stream().noneMatch(user -> user.getLogin().equals(userDTO.getLogin()))) {
            User user = UserDTO.dtoToUser(userDTO);
            userDao.saveUser(user);
        }
        return false;
    }

    public void updateUser(UserDTO userDTO, Long id) {
        userDao.updateUser(UserDTO.dtoToUser(userDTO), id);
    }

    public UserDTO getUserById(Long id) {
        User userByID = userDao.getUserById(id);
        if (userByID != null) {
            return UserDTO.userToDto(userByID);
        }
        return null;
    }

    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    public List<DrinkDTO> getFavouriteList(Long userId) {
        return userDao.getFavouriteDrinkList(userId)
                .stream()
                .map(DrinkDTO::drinkToDTO)
                .collect(Collectors.toList());
    }

    public List<DrinkDTO> getRequestFavouriteDrinkList(Long userId, int request, int size) {

        int fromIndex = (request - 1) * size;
        int toIndex = request * size;

        if (toIndex > userDao.getFavouriteDrinkList(userId).size()) {
            toIndex = userDao.getFavouriteDrinkList(userId).size();
        }
        return getFavouriteList(userId).subList(fromIndex, toIndex);
    }

    public Optional<Drink> isFavourite(String drinkName, Long id) {
        return userDao.isFavourite(drinkName, id);
    }

    public UserDTO getUserByLoginAndPass(String login, String password) {
        User userByLoginAndPass = userDao.getUserByLoginAndPass(login, password);
        return UserDTO.userToDto(userByLoginAndPass);
    }

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