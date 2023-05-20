package ru.theboys.deliverypointratingdataservice.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.Entities.Comment;
import ru.theboys.deliverypointratingdataservice.Entities.Views;
import ru.theboys.deliverypointratingdataservice.repo.CommentRepo;
import java.util.List;

@RestController
@RequestMapping("comment")
public class commentController {

    private final CommentRepo commentRepo;

    @Autowired
    public commentController(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @GetMapping
    @JsonView(Views.FullMessage.class)
    public List<Comment> list() {
        return commentRepo.findAll();
    }

    @GetMapping("{id}")
    public Comment getOne(@PathVariable("id") Comment comment) {
        return comment;

    }

    @PostMapping
    public Comment create(@RequestBody Comment comment) {

        return commentRepo.save(comment);
    }

    @PutMapping("{id}")
    public Comment update(@PathVariable("id") Comment commentFromDB,
                          @RequestBody Comment comment) {

        BeanUtils.copyProperties(comment, commentFromDB, "id");

        return commentRepo.save(commentFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Comment comment) {
        commentRepo.delete(comment);
    }

}
