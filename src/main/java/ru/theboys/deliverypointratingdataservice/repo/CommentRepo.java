package ru.theboys.deliverypointratingdataservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.theboys.deliverypointratingdataservice.Entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,String> {
}
