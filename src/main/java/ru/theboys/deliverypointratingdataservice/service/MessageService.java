package ru.theboys.deliverypointratingdataservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    private static final String NO_MESSAGE_FOUND = "No message with id %s found";
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return this.messageRepository.findAll();
    }

    public Message getMessage(String messageId) {
        return this.messageRepository.findById(messageId).orElseThrow(() -> new EntityNotFoundException(String.format(NO_MESSAGE_FOUND, messageId)));
    }

    public void addMessage(Message message) {
        this.messageRepository.save(message);
    }

    public void deleteMessage(String messageId) {
        this.getMessage(messageId);
        this.messageRepository.deleteById(messageId);
    }
}
