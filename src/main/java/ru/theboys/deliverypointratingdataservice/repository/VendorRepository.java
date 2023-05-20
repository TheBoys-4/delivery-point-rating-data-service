package ru.theboys.deliverypointratingdataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.theboys.deliverypointratingdataservice.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,String> {
}
