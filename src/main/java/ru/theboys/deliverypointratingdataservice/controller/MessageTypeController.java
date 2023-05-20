package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.entity.MessageType;
import ru.theboys.deliverypointratingdataservice.service.MessageService;
import ru.theboys.deliverypointratingdataservice.service.MessageTypeService;

import java.util.List;
@RestController
@RequestMapping("messageTypes")
public class MessageTypeController {
    private final MessageTypeService messageTypeService;

    @Autowired
    public MessageTypeController(MessageTypeService messageTypeService) {
        this.messageTypeService = messageTypeService;
    }

    @GetMapping
    public List<MessageType> getMessageTypes() {
        return this.messageTypeService.getAllMessageTypes();
    }

    @GetMapping("{id}")
    public MessageType getMessageTypeById(@PathVariable("id") String messageTypeId) {
        return this.messageTypeService.getMessageType(messageTypeId);
    }

    @PostMapping()
    public void addMessageType(@RequestBody MessageType messageType) {
        this.messageTypeService.addMessageType(messageType);
    }

    @PutMapping("{id}")
    public void updateMessageType(@PathVariable("id") String messageTypeId, @RequestBody MessageType messageType) {
        MessageType messageTypeFromDB =  this.messageTypeService.getMessageType(messageTypeId);
        BeanUtils.copyProperties(messageType,messageTypeFromDB,"id");
        this.messageTypeService.addMessageType(messageTypeFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String messageTypeId) {
        this.messageTypeService.deleteMessageType(messageTypeId);
    }
}
