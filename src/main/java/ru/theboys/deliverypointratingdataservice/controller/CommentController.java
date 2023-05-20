package ru.theboys.deliverypointratingdataservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.entitiy.Message;
import ru.theboys.deliverypointratingdataservice.entitiy.Views;
import ru.theboys.deliverypointratingdataservice.repo.CommentRepo;
import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentRepo commentRepo;

    @Autowired
    public CommentController(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @GetMapping
    @JsonView(Views.FullMessage.class)
    public List<Message> list() {
        return commentRepo.findAll();
    }

    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message comment) {
        return comment;

    }

    @PostMapping
    public Message create(@RequestBody Message comment) {

        return commentRepo.save(comment);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message commentFromDB,
                          @RequestBody Message comment) {

        BeanUtils.copyProperties(comment, commentFromDB, "id");

        return commentRepo.save(commentFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message comment) {
        commentRepo.delete(comment);
    }

}
