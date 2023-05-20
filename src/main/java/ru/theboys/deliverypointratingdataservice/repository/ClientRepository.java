package ru.theboys.deliverypointratingdataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theboys.deliverypointratingdataservice.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}
