package ru.theboys.deliverypointratingdataservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.MessageType;
import ru.theboys.deliverypointratingdataservice.repository.MessageTypeRepository;

import java.util.List;

@Service
public class MessageTypeService {
    private static final String NO_MESSAGE_TYPE_FOUND = "No message type with id %s found";
    private final MessageTypeRepository messageTypeRepository;

    @Autowired
    public MessageTypeService(MessageTypeRepository messageTypeRepository) {
        this.messageTypeRepository = messageTypeRepository;
    }

    public List<MessageType> getAllMessageTypes() {
        return this.messageTypeRepository.findAll();
    }

    public MessageType getMessageType(String messageTypeId) {
        return this.messageTypeRepository.findById(messageTypeId).orElseThrow(() -> new EntityNotFoundException(String.format(NO_MESSAGE_TYPE_FOUND, messageTypeId)));
    }

    public void addMessageType(MessageType messageType) {
        this.messageTypeRepository.save(messageType);
    }

    public void deleteMessageType(String messageTypeId) {
        this.getMessageType(messageTypeId);
        this.messageTypeRepository.deleteById(messageTypeId);
    }
}
