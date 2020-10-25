package com.infoshare.dao;

import com.infoshare.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public User get(Integer id){
        return entityManager.find(User.class, id);
    }

    public User getByEmail(String email){
        return entityManager.find(User.class, email);
    }

    public User getByLogin(String login){
        return entityManager.find(User.class, login);
    }

    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    public User update(Integer id, User user){
        User userToUpdate = get(id);
        if(userToUpdate != null) {
            userToUpdate.setLogin(user.getLogin());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setBirthDate(user.getBirthDate());
            userToUpdate.setFavourites(user.getFavourites());
            entityManager.merge(userToUpdate);
            return userToUpdate;
        }
        return null;
    }
    public void delete(Integer id) {
        User user = get(id);
        entityManager.remove(user);
    }
    public List<User> getAll() {
        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }
}
