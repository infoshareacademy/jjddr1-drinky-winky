package com.infoshare.service;

import com.infoshare.dao.MessageDao;
import com.infoshare.dto.MessageDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MessageService {

    @EJB
    MessageDao messageDao;

    public MessageDto getMessageById(Long id) {
        return MessageDto.messageToDto.apply(messageDao.getMessage(id));
    }

    public void saveMessage(MessageDto messageDto) {
        messageDao.setMessage(MessageDto.dtoToMessage.apply(messageDto));
    }


    public void updateMessage(MessageDto messageDto, Long id) {
        messageDao.updateMessage(MessageDto.dtoToMessage.apply(messageDto), id);
    }
}
