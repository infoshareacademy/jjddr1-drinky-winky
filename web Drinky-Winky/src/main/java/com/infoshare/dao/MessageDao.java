package com.infoshare.dao;

import com.infoshare.model.Message;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class MessageDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Message> allMessage() {
        TypedQuery<Message> query = entityManager.createQuery("SELECT m FROM Message m", Message.class);
        return query.getResultList();
    }

    public Optional<Message> findMessageById(Long id) {
        return allMessage().stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public void save(Message message) {
        entityManager.persist(message);
    }

    public void updateMessage(Long id, Message message) {
        Message messageById = findMessageById(id).orElseThrow();
        if (findMessageById(id).isPresent()) {
            messageById.setMessage(message.getMessage());
            entityManager.merge(messageById);
        }
    }

}

