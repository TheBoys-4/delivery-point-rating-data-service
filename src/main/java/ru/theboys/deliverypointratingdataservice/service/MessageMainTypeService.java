package ru.theboys.deliverypointratingdataservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.MessageMainType;
import ru.theboys.deliverypointratingdataservice.repository.MessageMainTypeRepository;

import java.util.List;
@Service
public class MessageMainTypeService {
    private static final String NO_MESSAGE_MAIN_TYPE_FOUND = "No message main type with id %s found";
    private final MessageMainTypeRepository messageMainTypeRepository;

    @Autowired
    public MessageMainTypeService(MessageMainTypeRepository messageMainTypeRepository) {
        this.messageMainTypeRepository = messageMainTypeRepository;
    }

    public List<MessageMainType> getAllMessageMainTypes() {
        return this.messageMainTypeRepository.findAll();
    }

    public MessageMainType getMessageMainType(String messageMainTypeId) {
        return this.messageMainTypeRepository.findById(messageMainTypeId).orElseThrow(() ->
                new EntityNotFoundException(String.format(NO_MESSAGE_MAIN_TYPE_FOUND, messageMainTypeId)));
    }

    public void addMessageMainType(MessageMainType messageMainType) {
        this.messageMainTypeRepository.save(messageMainType);
    }

    public void deleteMessageMainType(String messageMainTypeId) {
        this.getMessageMainType(messageMainTypeId);
        this.messageMainTypeRepository.deleteById(messageMainTypeId);
    }
}
