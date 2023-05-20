package ru.theboys.deliverypointratingdataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theboys.deliverypointratingdataservice.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
}
