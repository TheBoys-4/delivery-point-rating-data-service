package ru.theboys.deliverypointratingdataservice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.theboys.deliverypointratingdataservice.constants.ControllerConstants;
import ru.theboys.deliverypointratingdataservice.entity.Location;
import ru.theboys.deliverypointratingdataservice.service.LocationService;

import java.util.List;

@RestController
@RequestMapping(ControllerConstants.ROOT_PATH + "locations")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getLocation() {
        return this.locationService.getAllLocations();
    }

    @GetMapping("{id}")
    public Location getLocationById(@PathVariable("id") String locationId) {
        return this.locationService.getLocation(locationId);
    }

    @PostMapping()
    public void addLocation(@RequestBody Location location) {
        this.locationService.addLocation(location);
    }

    @PutMapping("{id}")
    public void updateLocation(@PathVariable("id") String locationId, @RequestBody Location location) {
        Location locationFromDB = this.locationService.getLocation(locationId);
        BeanUtils.copyProperties(location, locationFromDB, "id");
        this.locationService.addLocation(locationFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String locationId) {
        this.locationService.deleteLocation(locationId);
    }
}
