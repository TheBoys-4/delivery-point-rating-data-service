package ru.theboys.deliverypointratingdataservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.theboys.deliverypointratingdataservice.entity.*;
import ru.theboys.deliverypointratingdataservice.enums.LocationType;
import ru.theboys.deliverypointratingdataservice.enums.MessageMainType;
import ru.theboys.deliverypointratingdataservice.enums.MessageSource;
import ru.theboys.deliverypointratingdataservice.service.exportimport.JsonExportService;
import ru.theboys.deliverypointratingdataservice.service.exportimport.JsonImportService;
import ru.theboys.deliverypointratingdataservice.service.MessageService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

@SpringBootTest
class DeliveryPointRatingDataServiceApplicationTests {
    private final MessageService messageService;

    @Autowired
    public DeliveryPointRatingDataServiceApplicationTests(MessageService messageService) {
        this.messageService = messageService;
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
}
