package com.infoshare.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(UserDao user) {
        entityManager.persist(user);
    }

    public UserDao updateUser(UserDao user) {
        return entityManager.merge(user);
    }

    public UserDao getUserById(Long id) {
        return entityManager.find(UserDao.class, id);
    }

    public void deleteUserById(Long id) {
        UserDao user = getUserById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public List<UserDao> getUserList() {
        Query query = entityManager.createNamedQuery("User.getUserList");
        return query.getResultList();
    }

    public UserDao findUserByName(String name) {
        Query query = entityManager.createNamedQuery("User.findUserByName");
        query.setParameter("name", name);
        return (UserDao) query.getResultList().stream().findFirst().orElse(null);
    }

}
