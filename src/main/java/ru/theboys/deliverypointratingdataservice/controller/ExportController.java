package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.service.exportimport.ExcelExportService;
import ru.theboys.deliverypointratingdataservice.service.exportimport.JsonExportService;

@RestController
@RequestMapping(ControllerConstants.ROOT_PATH + "export")
public class ExportController {
    private final JsonExportService jsonExportService;
    private final ExcelExportService excelExportService;

    public ExportController(JsonExportService jsonExportService, ExcelExportService excelExportService) {
        this.jsonExportService = jsonExportService;
        this.excelExportService = excelExportService;
    }

    @GetMapping(value = "/json")
    public ResponseEntity<byte[]> exportMessagesAsJson() {
        return this.jsonExportService.export();
    }

    @GetMapping(value = "/xlsx")
    public ResponseEntity<byte[]> exportMessagesAsExcel() {
        return this.excelExportService.export();
    }
}
