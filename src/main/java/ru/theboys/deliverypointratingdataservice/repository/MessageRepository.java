package ru.theboys.deliverypointratingdataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theboys.deliverypointratingdataservice.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,String> {
}
