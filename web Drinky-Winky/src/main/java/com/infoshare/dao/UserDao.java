package com.infoshare.dao;

import com.infoshare.dto.UserDTO;
import com.infoshare.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(UserDTO userDTO) {
        User user = UserDTO.dtoToUser(userDTO);
        entityManager.persist(user);
    }

    public User updateUser(Long id, UserDTO userDTO) {
        User userToUpdate = entityManager.find(User.class, id);
        if (userToUpdate != null) {
            userToUpdate.setName(userDTO.getName());
            userToUpdate.setSurname(userDTO.getSurname());
            userToUpdate.setUserType(userDTO.getUserType());
            userToUpdate.setLogin(userDTO.getLogin());
            userToUpdate.setPassword(userDTO.getPassword());
            userToUpdate.setEmail(userDTO.getEmail());
        }
        return entityManager.merge(userToUpdate);
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    public void deleteUserById(Long id) {
        User user = getUserById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public List<User> getUserList() {
        Query query = entityManager.createNamedQuery("User.getUserList");
        return query.getResultList();
    }

    public User findUserByName(String name) {
        Query query = entityManager.createNamedQuery("User.findUserByName");
        query.setParameter("name", name);
        return (User) query.getResultList().stream().findFirst().orElse(null);
    }

}
