package ru.theboys.deliverypointratingdataservice.service.exportimport;

import org.springframework.http.ResponseEntity;

public interface ExportService {
    ResponseEntity<byte[]> export();
}
