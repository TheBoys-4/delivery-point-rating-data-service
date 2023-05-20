package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.entity.MessageMainType;
import ru.theboys.deliverypointratingdataservice.service.MessageMainTypeService;
import ru.theboys.deliverypointratingdataservice.service.MessageService;

import java.util.List;
@RestController
@RequestMapping("messageMainTypes")
public class MessageMainTypeController {
    private final MessageMainTypeService messageMainTypeService;

    @Autowired
    public MessageMainTypeController(MessageMainTypeService messageMainTypeService) {
        this.messageMainTypeService = messageMainTypeService;
    }

    @GetMapping
    public List<MessageMainType> getMessageMainTypes() {
        return this.messageMainTypeService.getAllMessageMainTypes();
    }

    @GetMapping("{id}")
    public MessageMainType getMessageMainTypeById(@PathVariable("id") String messageMainTypeId) {
        return this.messageMainTypeService.getMessageMainType(messageMainTypeId);
    }

    @PostMapping()
    public void addMessageMainType(@RequestBody MessageMainType messageMainType) {
        this.messageMainTypeService.addMessageMainType(messageMainType);
    }

    @PutMapping("{id}")
    public void updateMessageMainType(@PathVariable("id") String messageMainTypeId, @RequestBody MessageMainType messageMainType) {
        this.messageMainTypeService.getMessageMainType(messageMainTypeId);
        this.messageMainTypeService.addMessageMainType(messageMainType);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String messageMainType) {
        this.messageMainTypeService.deleteMessageMainType(messageMainType);
    }
}
