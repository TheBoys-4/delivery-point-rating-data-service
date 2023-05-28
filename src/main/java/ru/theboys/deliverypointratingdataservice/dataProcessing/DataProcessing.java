package ru.theboys.deliverypointratingdataservice.dataProcessing;

import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.entity.MessageType;

public class DataProcessing {

    public static void ClassificationByText(Message message) {
        String text = message.getText();

        for (String target : BlackList.PRODUCT_DESCRIPTION_LIST) {
            if (text.contains(target)) {
                message.getMessageType().add(new MessageType("PRODUCT_DESCRIPTION"));
            }
        }
        for (String target : BlackList.PRODUCT_ORDERING_LIST) {
            if (text.contains(target)) {
                message.getMessageType().add(new MessageType("PRODUCT_ORDERING"));
            }
        }
        for (String target : BlackList.PRODUCT_RECEIVING_LIST) {
            if (text.contains(target)) {
                message.getMessageType().add(new MessageType("PRODUCT_RECEIVING"));
            }
        }
        for (String target : BlackList.ORDER_CONDITION_LIST) {
            if (text.contains(target)) {
                message.getMessageType().add(new MessageType("ORDER_CONDITION"));
            }
        }
        for (String target : BlackList.PRODUCT_CONDITION_LIST) {
            if (text.contains(target)) {
                message.getMessageType().add(new MessageType("PRODUCT_CONDITION"));
            }
        }
        for (String target : BlackList.DELIVERY_POINT_CONDITION_LIST) {
            if (text.contains(target)) {
                message.getMessageType().add(new MessageType("DELIVERY_POINT_CONDITION"));
            }
        }
        for (String target : BlackList.DELIVERY_LIST) {
            if (text.contains(target)) {
                message.getMessageType().add(new MessageType("DELIVERY"));
            }
        }
        for (String target : BlackList.NOTIFICATION_LIST) {
            if (text.contains(target)) {
                message.getMessageType().add(new MessageType("NOTIFICATION"));
            }
        }

        if (message.getMessageType().isEmpty()) {
            message.getMessageType().add(new MessageType("OTHER"));
        }
    }
}
