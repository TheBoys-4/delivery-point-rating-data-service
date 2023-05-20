package ru.theboys.deliverypointratingdataservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.theboys.deliverypointratingdataservice.entitiy.Message;

public interface CommentRepo extends JpaRepository<Message,String> {
}
