package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.service.ImportService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(ControllerConstants.ROOT_PATH + "import")
public class ImportController {
    private final ImportService importService;

    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @PostMapping()
    public void importFromJson(@RequestBody String JSON) {
        this.importService.importJSON(JSON);
    }

}
