package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.service.exportimport.JsonImportService;

@RestController
@RequestMapping(ControllerConstants.ROOT_PATH + "import")
public class ImportController {
    private final JsonImportService jsonImportService;

    public ImportController(JsonImportService jsonImportService) {
        this.jsonImportService = jsonImportService;
    }

    @PostMapping()
    public void importFromJson(@RequestParam("file")MultipartFile file) {

        this.jsonImportService.importJSON(file);
    }

}
