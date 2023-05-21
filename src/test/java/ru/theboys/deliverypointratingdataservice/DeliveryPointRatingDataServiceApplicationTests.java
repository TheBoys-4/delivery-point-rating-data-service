package ru.theboys.deliverypointratingdataservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;
import ru.theboys.deliverypointratingdataservice.entity.*;
import ru.theboys.deliverypointratingdataservice.enums.LocationType;
import ru.theboys.deliverypointratingdataservice.enums.MessageMainType;
import ru.theboys.deliverypointratingdataservice.enums.MessageSource;
import ru.theboys.deliverypointratingdataservice.service.ExportService;
import ru.theboys.deliverypointratingdataservice.service.ImportService;
import ru.theboys.deliverypointratingdataservice.service.MessageService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

@SpringBootTest
class DeliveryPointRatingDataServiceApplicationTests {
    private final MessageService messageService;
    private final ExportService exportService;
    private final ImportService importService;
    @Autowired
    public DeliveryPointRatingDataServiceApplicationTests(MessageService messageService, ExportService exportService, ImportService importService) {
        this.messageService = messageService;
        this.exportService = exportService;
        this.importService = importService;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void addToDBTest() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Message message = new Message(Date.valueOf(LocalDate.now()), random.nextInt(5) + 1,
                    new Location("ВАО","Измайлово","ул. Первомайская д. 123432","10:10", LocationType.CITY), new Vendor("Yandex"),
                    new Client("Alex" + random.nextInt(100), "+7900" + random.nextInt(1000), "@@", "M", 10),
                    new MessageType("Оплата заказа",MessageMainType.RECEIVING_AN_ORDER), MessageSource.TEST,
                    "Привет, я: " + random.nextInt(100));
            this.messageService.addMessage(message);
        }
    }

    @Test
    void exportTest(){

        String result = null;
        result = new String(this.exportService.export().getBody());
        System.out.println(result);
    }

    @Test
    void importFromJSONTest(){
    }


}
