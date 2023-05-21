package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.service.ExportService;

import java.io.File;

@RestController
@RequestMapping(ControllerConstants.ROOT_PATH + "export")
public class ExportController {
    private final ExportService exportService;

    public ExportController(ExportService exportService) {
        this.exportService = exportService;
    }

    @GetMapping
    public ResponseEntity<byte[]> exportClientsJson() {
        return this.exportService.jsonExport();
    }

    @GetMapping
    public ResponseEntity<byte[]> getClientsExcel() {
        return this.exportService.excelExport();
    }

}
