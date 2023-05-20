package ru.theboys.deliverypointratingdataservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.Views;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;

@Service
public class ExportService {
        private static final String SERIALIZE_FAILED = "Serialize failed";
    private final MessageRepository messageRepository;

    @Autowired
    public ExportService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String export() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithView(Views.Export.class).writeValueAsString(messageRepository.findAll());
        } catch (JsonProcessingException e) {
            throw new EntityNotFoundException(SERIALIZE_FAILED);
        }
    }
}
