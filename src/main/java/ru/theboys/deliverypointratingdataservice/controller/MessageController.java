package ru.theboys.deliverypointratingdataservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.entity.Views;
import ru.theboys.deliverypointratingdataservice.repository.MessageRepository;
import ru.theboys.deliverypointratingdataservice.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMessages() {
        return this.messageService.getAllMessages();
    }

    @GetMapping("{id}")
    public Message getMessageById(@PathVariable("id") String messageId) {
        return this.messageService.getMessage(messageId);
    }

    @PostMapping()
    public void addMessage(@RequestBody Message message) {
        this.messageService.addMessage(message);
    }

    @PutMapping("{id}")
    public void updateMessage(@PathVariable("id") String messageId, @RequestBody Message message) {
        Message messageFromDB = this.messageService.getMessage(messageId);
        BeanUtils.copyProperties(message,messageFromDB,"id");
        this.messageService.addMessage(messageFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String messageId) {
        this.messageService.deleteMessage(messageId);
    }
}
