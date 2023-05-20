package ru.theboys.deliverypointratingdataservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.theboys.deliverypointratingdataservice.entity.Location;
import ru.theboys.deliverypointratingdataservice.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService {
    private static final String NO_LOCATION_FOUND = "No location with id %s found";
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return this.locationRepository.findAll();
    }

    public Location getLocation(String locationId) {
        return this.locationRepository.findById(locationId).orElseThrow(() -> new EntityNotFoundException(String.format(NO_LOCATION_FOUND, locationId)));
    }

    public void addLocation(Location location) {
        this.locationRepository.save(location);
    }

    public void deleteLocation(String locationId) {
        this.getLocation(locationId);
        this.locationRepository.deleteById(locationId);
    }
}
