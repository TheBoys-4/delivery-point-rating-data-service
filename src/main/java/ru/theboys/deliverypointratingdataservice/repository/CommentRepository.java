package ru.theboys.deliverypointratingdataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.theboys.deliverypointratingdataservice.entity.Message;

public interface CommentRepository extends JpaRepository<Message,String> {
}
