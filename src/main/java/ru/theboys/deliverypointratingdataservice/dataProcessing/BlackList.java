package ru.theboys.deliverypointratingdataservice.dataProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackList {
    public static final List<String>  PRODUCT_DESCRIPTION_LIST = new ArrayList<>(Arrays.asList("описание", "на сайте", "название", "фото", "картинка"));
    public static final List<String>  PRODUCT_ORDERING_LIST = new ArrayList<>(Arrays.asList("ближайщий", "ближе", "близко", "далеко", "подходящий постамат", "лучший постамат"));
    public static final List<String>  PRODUCT_RECEIVING_LIST = new ArrayList<>(Arrays.asList("ячейка", "оплата", "получение заказа", "принятие", "открытие"));
    public static final List<String>  ORDER_CONDITION_LIST = new ArrayList<>(Arrays.asList("упаковка", "распаковка", "пакет", "комплект", "коробка", "коробки","комплектация"));
    public static final List<String>  PRODUCT_CONDITION_LIST = new ArrayList<>(Arrays.asList("постамат", "качество", "модель", "материал", "конструкция",
            "модели", "товара"));
    public static final List<String>  DELIVERY_POINT_CONDITION_LIST = new ArrayList<>(Arrays.asList("постамат", "постамата", "постаматы"));
    public static final List<String>  DELIVERY_LIST = new ArrayList<>(Arrays.asList("курьер", "долго", "доставка", "курьеров"
            , "курьера", "прислали", ""));
    public static final List<String>  NOTIFICATION_LIST = new ArrayList<>(Arrays.asList("уведомление", "уведомления", "уведомили", "сообщение", "письмо"));
}
