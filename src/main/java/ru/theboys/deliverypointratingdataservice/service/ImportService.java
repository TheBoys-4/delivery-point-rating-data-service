package ru.theboys.deliverypointratingdataservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.entity.Views;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ImportService {
    private static final String DESERIALIZATION_FAILED = "Deserialization failed";
    private final MessageRepository messageRepository;

    @Autowired
    public ImportService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void importJSON(MultipartFile multipartFile){
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(multipartFile.getName()+"1");

            OutputStream os = new FileOutputStream(file);
            os.write(multipartFile.getBytes());

            List<Message> messages = mapper.readerWithView(Views.Import.class).forType(new TypeReference<List<Message>>() {
            }).readValue(file);
            for(Message message:messages){
                messageRepository.save(message);
            }
        } catch (JsonProcessingException e) {
            throw new EntityNotFoundException(DESERIALIZATION_FAILED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
