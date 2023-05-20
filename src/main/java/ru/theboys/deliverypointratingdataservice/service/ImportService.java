package ru.theboys.deliverypointratingdataservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.entity.Views;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;

import java.util.List;

@Service
public class ImportService {
    private static final String DERIALIZE_FAILED = "Deserialize failed";
    private final MessageRepository messageRepository;

    @Autowired
    public ImportService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void importJSON(String JSON){
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Message> messages = mapper.readerWithView(Views.Import.class).forType(new TypeReference<List<Message>>() {
            }).readValue(JSON);
            for(Message message:messages){
                messageRepository.save(message);
            }
        } catch (JsonProcessingException e) {
            throw new EntityNotFoundException(DERIALIZE_FAILED);
        }
    }
}
