package ru.theboys.deliverypointratingdataservice.service.exportimport;

import org.springframework.web.multipart.MultipartFile;

public interface ImportService {
    void importFile(MultipartFile multipartFile);
}
