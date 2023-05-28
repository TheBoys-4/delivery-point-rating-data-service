package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.service.exportimport.ExcelImportService;
import ru.theboys.deliverypointratingdataservice.service.exportimport.JsonImportService;

@RestController
@RequestMapping(ControllerConstants.ROOT_PATH + "import")
public class ImportController {
    private final JsonImportService jsonImportService;
    private final ExcelImportService excelImportService;

    public ImportController(JsonImportService jsonImportService, ExcelImportService excelImportService) {
        this.jsonImportService = jsonImportService;
        this.excelImportService = excelImportService;
    }

    @PostMapping(value = "/json")
    public void importFromJson(@RequestParam("file") MultipartFile file) {
        this.jsonImportService.importFile(file);
    }

    @PostMapping(value = "/xlsx")
    public void importFromExcel(@RequestParam("file") MultipartFile file) {
        this.excelImportService.importFile(file);
    }
}
