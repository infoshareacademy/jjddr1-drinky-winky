package com.infoshare.dao;

import com.infoshare.model.Drink;
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

    public void updateMessage(Message message, Long id) {
        Message messageToUpdate = entityManager.find(Message.class, id);
        if (messageToUpdate.getId().equals(message.getId())) {
            messageToUpdate.setMessage(message.getMessage());
            entityManager.merge(messageToUpdate);
        }

        }
    }

