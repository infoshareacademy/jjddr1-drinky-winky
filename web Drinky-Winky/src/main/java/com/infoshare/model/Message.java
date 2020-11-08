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
    private String text;

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String message) {
        this.text = message;
    }
}
