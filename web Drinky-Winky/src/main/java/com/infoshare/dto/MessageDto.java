package com.infoshare.dto;

import com.infoshare.model.Message;

import java.util.function.Function;

public class MessageDto {

    private Long id;
    private String message;

    public static Function<MessageDto, Message> dtoToMessage = new Function<MessageDto, Message>() {
        @Override
        public Message apply(MessageDto messageDto) {
            return new Message(messageDto.getMessage());
        }
    };

    public static Function<Message, MessageDto> messageToDto = new Function<Message, MessageDto>() {
        @Override
        public MessageDto apply(Message message) {
            return new MessageDto(message.getId(), message.getMessage());
        }
    };

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
