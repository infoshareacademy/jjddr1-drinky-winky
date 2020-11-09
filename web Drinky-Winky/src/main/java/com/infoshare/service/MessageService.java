package com.infoshare.service;

import com.infoshare.dao.MessageDao;
import com.infoshare.dto.MessageDto;
import com.infoshare.model.Message;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@RequestScoped
public class MessageService {

    @Inject
    MessageDao messageDao;

    public List<MessageDto> allMessage() {
        return messageDao.allMessage().stream().map(MessageDto::messageToDto).collect(Collectors.toList());
    }

    public Optional<MessageDto> getMessageById(Long id) {
        return messageDao.findMessageById(id).stream().map(MessageDto::messageToDto).findFirst();
    }

    public void saveMessage(MessageDto messageDto) {
        messageDao.save(MessageDto.dtoToMessage(messageDto));
    }

    public void clean(Long id){
        messageDao.delete(id);
    }

    public void updateMessage(MessageDto messageDto, Long id) {
        Message message = MessageDto.dtoToMessage(messageDto);
        messageDao.updateMessage(id, message);
    }

    //TODO IT SHOULD BE WORKING FOR ANOTHER numberOfMessage
    //method work only 1L numberOfMessage and it's reservation for ADMIN message
    public void leaveMessage(Long numberOfMessage, String message) {

        MessageDto messageDto = new MessageDto(numberOfMessage, message);

        if (allMessage().isEmpty()) {
            saveMessage(messageDto);
        } else {
            updateMessage(messageDto, numberOfMessage);
        }
    }
}
