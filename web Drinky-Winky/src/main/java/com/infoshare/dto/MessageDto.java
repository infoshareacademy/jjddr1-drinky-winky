package com.infoshare.dto;

import com.infoshare.model.Message;

public class MessageDto {

    private Long id;
    private String message;

    public static MessageDto messageToDto(Message message) {
        return new MessageDto(message.getId() ,message.getInformation());
    }

    public static Message dtoToMessage(MessageDto messageDto) {
        return new Message(messageDto.getId(), messageDto.getMessage());
    }

    public MessageDto(String message) {
        this.message = message;
    }

    public MessageDto(Long id, String message) {
        this.id = id;
        this.message = message;
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
