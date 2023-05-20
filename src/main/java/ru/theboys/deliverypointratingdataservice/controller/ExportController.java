package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.theboys.deliverypointratingdataservice.service.ExportService;

@RestController
@RequestMapping("export")
public class ExportController {
    private final ExportService exportService;

    public ExportController(ExportService exportService) {
        this.exportService = exportService;
    }

    @GetMapping
    public String getClients() {
        return this.exportService.export();
    }

}
