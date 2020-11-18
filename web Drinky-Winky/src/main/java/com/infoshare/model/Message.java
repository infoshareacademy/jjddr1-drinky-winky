package com.infoshare.model;

import javax.persistence.*;

@NamedQuery(
        name = Message.GET_MESSAGE,
        query = "SELECT m FROM Message m"
)

@Table
@Entity
public class Message {
    public static final String GET_MESSAGE = "Message.getMessage";

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String message;


    public Message(String message) {
        this.message = message;
    }

    public Message(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
