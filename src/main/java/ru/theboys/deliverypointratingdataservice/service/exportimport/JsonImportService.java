package ru.theboys.deliverypointratingdataservice.service.exportimport;

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
public class JsonImportService implements ImportService {
    private static final String DESERIALIZATION_FAILED = "Deserialization failed";

    private final ObjectMapper objectMapper;
    private final MessageRepository messageRepository;

    @Autowired
    public JsonImportService(ObjectMapper objectMapper, MessageRepository messageRepository) {
        this.objectMapper = objectMapper;
        this.messageRepository = messageRepository;
    }

    public void importFile(MultipartFile multipartFile) {
        try {
            File file = new File(multipartFile.getName());

            OutputStream os = new FileOutputStream(file);
            os.write(multipartFile.getBytes());

            List<Message> messages = objectMapper.readerWithView(Views.Import.class)
                    .forType(new TypeReference<List<Message>>() {
                    })
                    .readValue(file);
            for (Message message : messages) {
                messageRepository.save(message);
            }
        } catch (JsonProcessingException e) {
            throw new EntityNotFoundException(DESERIALIZATION_FAILED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
