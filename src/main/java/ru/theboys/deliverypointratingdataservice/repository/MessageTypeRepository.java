package ru.theboys.deliverypointratingdataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theboys.deliverypointratingdataservice.entity.MessageType;

@Repository
public interface MessageTypeRepository extends JpaRepository<MessageType,String> {
}