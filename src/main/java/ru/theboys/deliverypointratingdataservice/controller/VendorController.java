package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.entity.Message;
import ru.theboys.deliverypointratingdataservice.entity.Vendor;
import ru.theboys.deliverypointratingdataservice.service.MessageService;
import ru.theboys.deliverypointratingdataservice.service.VendorService;

import java.util.List;
@RestController
@RequestMapping(ControllerConstants.ROOT_PATH + "vendors")
public class VendorController {
    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<Vendor> getVendors() {
        return this.vendorService.getAllVendors();
    }

    @GetMapping("{id}")
    public Vendor getVendorById(@PathVariable("id") String vendorId) {
        return this.vendorService.getVendor(vendorId);
    }

    @PostMapping()
    public void addVendor(@RequestBody Vendor vendor) {
        this.vendorService.addVendor(vendor);
    }

    @PutMapping("{id}")
    public void updateVendor(@PathVariable("id") String vendorId, @RequestBody Vendor vendor) {
        Vendor vendorFromDB = this.vendorService.getVendor(vendorId);
        BeanUtils.copyProperties(vendor, vendorFromDB, "id");
        this.vendorService.addVendor(vendorFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String vendorId) {
        this.vendorService.deleteVendor(vendorId);
    }
}
