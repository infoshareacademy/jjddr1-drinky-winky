package com.infoshare.dao;

import jdk.jshell.spi.ExecutionControl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class User {
    @PersistenceContext
    EntityManager entityManager;

    public void save(User user) { entityManager.persist(user);}

    public User updateUser(User user) { return entityManager.merge(user); }

    public User getUserById(Long id) { return entityManager.find(User.class, id);}

    public void deleteUserById(Long id) {
        User user = getUserById(id);
        if ( user != null) {
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
