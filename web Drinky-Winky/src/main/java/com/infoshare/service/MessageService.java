package com.infoshare.service;

import com.infoshare.dao.MessageDao;
import com.infoshare.dto.MessageDto;
import com.infoshare.model.Message;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MessageService {

    @EJB
    MessageDao messageDao;

    public MessageDto getMessageById(Long id) {
        return MessageDto.messageToDto.apply(messageDao.getMessage(id));
    }

    public void setMessage(MessageDto messageDto){
        messageDao.setMessage(MessageDto.dtoToMessage.apply(messageDto));
    }

}
