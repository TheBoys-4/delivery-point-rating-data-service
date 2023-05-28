package ru.theboys.deliverypointratingdataservice.utils;

import ru.theboys.deliverypointratingdataservice.dataProcessing.DataProcessing;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.entity.RawMessage;
import ru.theboys.deliverypointratingdataservice.enums.MessageSource;

public class MessageUtil {

    public static Message messageFromRaw(RawMessage rawMessage){
        Message message = new Message();
        message.setClient(rawMessage.getClient());
        message.setLocation(rawMessage.getLocation());
        message.setScore(rawMessage.getScore());
        message.setDateTime(rawMessage.getDateTime());
        message.setText(rawMessage.getText());
        message.setVendor(rawMessage.getVendor());
        for(MessageSource name: MessageSource.values()){
            if(rawMessage.getMessageSource().equals(name.getValue())){
                message.setMessageSource(name);
            }
        }
        if(message.getMessageSource()==null){
            message.setMessageSource(MessageSource.OTHER);
        }
        DataProcessing.ClassificationByText(message);
        return message;
    }

}
