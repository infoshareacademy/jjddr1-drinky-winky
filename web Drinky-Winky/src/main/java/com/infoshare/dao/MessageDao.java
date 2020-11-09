package com.infoshare.dao;

import com.infoshare.model.Message;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MessageDao {

    @PersistenceContext
    EntityManager entityManager;

    public Message getMessage(Long id) {
        return entityManager.find(Message.class, id);
    }

    public void setMessage(Message message) {
        entityManager.persist(message);
    }

}
