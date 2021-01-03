package com.infoshare.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(
        name = Message.GET_MESSAGE,
        query = "SELECT m FROM Message m"
)

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    public static final String GET_MESSAGE = "Message.getMessage";

    @Id
    private Long id;

    private String information;
}
