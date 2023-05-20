package ru.theboys.deliverypointratingdataservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.theboys.deliverypointratingdataservice.entity.*;
import ru.theboys.deliverypointratingdataservice.enums.LocationType;
import ru.theboys.deliverypointratingdataservice.enums.MessageMainType;
import ru.theboys.deliverypointratingdataservice.enums.MessageSource;
import ru.theboys.deliverypointratingdataservice.service.ExportService;
import ru.theboys.deliverypointratingdataservice.service.ImportService;
import ru.theboys.deliverypointratingdataservice.service.MessageService;

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
        String result = this.exportService.export();
        System.out.println(result);
    }

    @Test
    void importFromJSONTest(){
        String JSON = "[{\"id\":\"db6563b1-5f52-4dc7-a50f-4de2ef4c7d69\",\"dateTime\":1684530000000,\"score\":5,\"location\":{\"id\":\"287f1a44-1158-416e-a4d9-49bf8ffc7459\",\"administrativeDistrict\":\"ВАО\",\"district\":\"Измайлово\",\"address\":\"ул. Первомайская д. 123432\",\"coordinate\":\"10:10\",\"locationType\":\"CITY\"},\"vendor\":{\"id\":\"c3760251-1416-4451-9f65-142179937ea0\",\"name\":\"Yandex\"},\"client\":{\"id\":\"7404873a-03ae-46c0-91f2-a1613cb78153\",\"name\":\"Alex73\",\"phoneNumber\":\"+7900349\",\"email\":\"@@\",\"sex\":\"M\",\"age\":10},\"messageType\":{\"id\":\"fd443b1f-9913-46e4-92f7-139406c0a714\",\"name\":\"Оплата заказа\",\"messageMainType\":\"RECEIVING_AN_ORDER\"},\"messageSource\":\"TEST\",\"text\":\"Привет, я: 3\"},{\"id\":\"3e5940fe-0e7e-45a8-a420-fd5bee7ecf45\",\"dateTime\":1684530000000,\"score\":1,\"location\":{\"id\":\"99b09d3c-7e9f-4d6c-afbf-24582fa07d23\",\"administrativeDistrict\":\"ВАО\",\"district\":\"Измайлово\",\"address\":\"ул. Первомайская д. 123432\",\"coordinate\":\"10:10\",\"locationType\":\"CITY\"},\"vendor\":{\"id\":\"846e84d0-47e0-4791-901f-7d8d0c491f47\",\"name\":\"Yandex\"},\"client\":{\"id\":\"fbddc21c-911b-440e-98e6-4fc26a9397d8\",\"name\":\"Alex31\",\"phoneNumber\":\"+7900767\",\"email\":\"@@\",\"sex\":\"M\",\"age\":10},\"messageType\":{\"id\":\"0325ffc7-0cbf-4c49-acf5-30cc190c2ab2\",\"name\":\"Оплата заказа\",\"messageMainType\":\"RECEIVING_AN_ORDER\"},\"messageSource\":\"TEST\",\"text\":\"Привет, я: 59\"},{\"id\":\"28fa6e34-47a6-4494-b8d6-b7a11b13b3b4\",\"dateTime\":1684530000000,\"score\":2,\"location\":{\"id\":\"8deeb8a9-0201-492d-b281-a2748e160fb7\",\"administrativeDistrict\":\"ВАО\",\"district\":\"Измайлово\",\"address\":\"ул. Первомайская д. 123432\",\"coordinate\":\"10:10\",\"locationType\":\"CITY\"},\"vendor\":{\"id\":\"ac91d6ed-b99a-466a-8c47-cfeea2f67def\",\"name\":\"Yandex\"},\"client\":{\"id\":\"c4600443-0e2b-4cd7-b590-e4fdc749c8d6\",\"name\":\"Alex27\",\"phoneNumber\":\"+7900874\",\"email\":\"@@\",\"sex\":\"M\",\"age\":10},\"messageType\":{\"id\":\"5cd2125b-605d-4fd5-ae34-ecf925ef3327\",\"name\":\"Оплата заказа\",\"messageMainType\":\"RECEIVING_AN_ORDER\"},\"messageSource\":\"TEST\",\"text\":\"Привет, я: 2\"},{\"id\":\"a1863b91-4d8c-48ed-af76-3fc5aaa3d6d0\",\"dateTime\":1684530000000,\"score\":4,\"location\":{\"id\":\"46377b29-b025-485d-8fd7-459c81fa0b5b\",\"administrativeDistrict\":\"ВАО\",\"district\":\"Измайлово\",\"address\":\"ул. Первомайская д. 123432\",\"coordinate\":\"10:10\",\"locationType\":\"CITY\"},\"vendor\":{\"id\":\"202a2d41-fcc7-42a0-bb17-0e31838cec09\",\"name\":\"Yandex\"},\"client\":{\"id\":\"e06fb004-6696-4a8f-b4c2-02a7548252fd\",\"name\":\"Alex72\",\"phoneNumber\":\"+7900556\",\"email\":\"@@\",\"sex\":\"M\",\"age\":10},\"messageType\":{\"id\":\"d2bc4b56-60b8-46ed-9c7d-b428d7fc890c\",\"name\":\"Оплата заказа\",\"messageMainType\":\"RECEIVING_AN_ORDER\"},\"messageSource\":\"TEST\",\"text\":\"Привет, я: 26\"},{\"id\":\"f3dfdad7-c412-4192-8b14-f1e7bcebee44\",\"dateTime\":1684530000000,\"score\":5,\"location\":{\"id\":\"499199b7-978e-497d-80a8-235b6b75a6e2\",\"administrativeDistrict\":\"ВАО\",\"district\":\"Измайлово\",\"address\":\"ул. Первомайская д. 123432\",\"coordinate\":\"10:10\",\"locationType\":\"CITY\"},\"vendor\":{\"id\":\"ee2918b3-618b-4dff-a080-2471b16dd219\",\"name\":\"Yandex\"},\"client\":{\"id\":\"87cc4c9b-bcb4-4668-afe9-e8fde4553636\",\"name\":\"Alex89\",\"phoneNumber\":\"+7900918\",\"email\":\"@@\",\"sex\":\"M\",\"age\":10},\"messageType\":{\"id\":\"3114f62d-a80b-4479-8825-ef87a915c3fb\",\"name\":\"Оплата заказа\",\"messageMainType\":\"RECEIVING_AN_ORDER\"},\"messageSource\":\"TEST\",\"text\":\"Привет, я: 5\"}]";
        this.importService.importJSON(JSON);
    }


}
