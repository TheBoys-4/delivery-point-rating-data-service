package ru.theboys.deliverypointratingdataservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.Vendor;
import ru.theboys.deliverypointratingdataservice.repository.VendorRepository;

import java.util.List;

@Service
public class VendorService {
    private static final String NO_VENDOR_FOUND = "No vendor with id %s found";
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> getAllVendors() {
        return this.vendorRepository.findAll();
    }

    public Vendor getVendor(String vendorId) {
        return this.vendorRepository.findById(vendorId).orElseThrow(() -> new EntityNotFoundException(String.format(NO_VENDOR_FOUND, vendorId)));
    }

    public void addVendor(Vendor vendor) {
        this.vendorRepository.save(vendor);
    }

    public void deleteVendor(String vendorId) {
        this.getVendor(vendorId);
        this.vendorRepository.deleteById(vendorId);
    }
}
