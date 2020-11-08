package com.infoshare.model;

import javax.persistence.*;

@NamedQuery(
        name = "Message.getMessage",
        query = "SELECT m FROM Message m"
)

@Table
@Entity
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String message;

    public Message(String message) {
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
