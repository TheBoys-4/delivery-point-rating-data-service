package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.entity.MessageType;
import ru.theboys.deliverypointratingdataservice.service.MessageTypeService;

import java.util.List;

@RestController
@RequestMapping(ControllerConstants.ROOT_PATH + "messageTypes")
public class MessageTypeController {
    private final MessageTypeService messageTypeService;

    @Autowired
    public MessageTypeController(MessageTypeService messageTypeService) {
        this.messageTypeService = messageTypeService;
    }

    @GetMapping
    public ResponseEntity<List<MessageType>> getMessageTypes() {
        HttpHeaders headers = new HttpHeaders();
        List<MessageType> messageTypes = this.messageTypeService.getAllMessageTypes();
        headers.add("Access-Control-Expose-Headers", "X-Total-Count");
        headers.add("X-Total-Count", String.valueOf(messageTypes.size()));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(messageTypes.size())
                .body(messageTypes);
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