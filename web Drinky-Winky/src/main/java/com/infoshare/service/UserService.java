package com.infoshare.service;

import com.infoshare.dao.UserDao;
import com.infoshare.dto.UserDTO;
import com.infoshare.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;


@RequestScoped
public class UserService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private UserDao userDao;

    public void saveUser(UserDTO userDTO) {
        User user = UserDTO.dtoToUser(userDTO);
        userDao.saveUser(user);
    }

    public void updateUser(UserDTO userDTO) {
        userDao.updateUser(UserDTO.dtoToUser(userDTO));
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }
}
