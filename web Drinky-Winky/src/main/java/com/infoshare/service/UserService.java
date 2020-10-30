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
        userDao.save(userDTO);
    }

    public User updateUser(Long id, UserDTO userDTO) {
        return userDao.updateUser(id, userDTO);
    }

    public User getUserById(Long id){
        return userDao.getUserById(id);
    }

    public void deleteUserById(Long id){
        userDao.deleteUserById(id);
    }
}
