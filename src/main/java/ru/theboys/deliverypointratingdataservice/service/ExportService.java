package ru.theboys.deliverypointratingdataservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.headers.Header;
import jakarta.persistence.EntityNotFoundException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.Views;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class ExportService {
        private static final String SERIALIZATION_FAILED = "Serialization failed";
    private final MessageRepository messageRepository;

    @Autowired
    public ExportService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public ResponseEntity<byte[]> jsonExport() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String test = mapper.writerWithView(Views.Export.class).writeValueAsString(messageRepository.findAll());
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            return new ResponseEntity<>(test.getBytes(),headers, HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            throw new EntityNotFoundException(SERIALIZATION_FAILED);
        }
    }

    public ResponseEntity<byte[]> excelExport() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String test = mapper.writerWithView(Views.Export.class).writeValueAsString(messageRepository.findAll());
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            return new ResponseEntity<>(test.getBytes(),headers, HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            throw new EntityNotFoundException(SERIALIZATION_FAILED);
        }
    }
}
