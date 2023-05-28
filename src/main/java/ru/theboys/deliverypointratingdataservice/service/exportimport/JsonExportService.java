package ru.theboys.deliverypointratingdataservice.service.exportimport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.Views;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;

@Service
public class JsonExportService implements ExportService {
    private static final String JSON_EXPORT_ERROR = "Failed to create JSON file: ";

    private final ObjectMapper objectMapper;
    private final MessageRepository messageRepository;

    @Autowired
    public JsonExportService(ObjectMapper objectMapper, MessageRepository messageRepository) {
        this.objectMapper = objectMapper;
        this.messageRepository = messageRepository;
    }

    public ResponseEntity<byte[]> export() {
        try {
            String json = objectMapper.writerWithView(Views.Export.class).writeValueAsString(messageRepository.findAll());
            return toResponseEntity(json.getBytes());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(JSON_EXPORT_ERROR + e.getMessage());
        }
    }

    private ResponseEntity<byte[]> toResponseEntity(byte[] bytes) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=export.json");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(bytes.length)
                .body(bytes);
    }
}
