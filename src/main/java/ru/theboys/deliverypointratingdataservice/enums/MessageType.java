package ru.theboys.deliverypointratingdataservice.enums;

public enum MessageType {
    PRODUCT_DESCRIPTION("Описание товара"),
    PRODUCT_ORDERING("Оформление заказа"),
    PRODUCT_RECEIVING("Получение заказа"),
    ORDER_CONDITION("Полученный заказ"),
    PRODUCT_CONDITION("Товар"),
    DELIVERY_POINT_CONDITION("Постамат"),
    DELIVERY("Доставка"),
    NOTIFICATION("Уведомление"),
    OTHER("Другое");

    public final String value;

    MessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
