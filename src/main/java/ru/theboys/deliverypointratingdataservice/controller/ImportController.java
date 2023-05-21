package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.service.ImportService;

@RestController
@RequestMapping(ControllerConstants.ROOT_PATH + "import")
public class ImportController {
    private final ImportService importService;

    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @PostMapping()
    public void importFromJson(@RequestParam("file")MultipartFile file) {

        this.importService.importJSON(file);
    }

}
