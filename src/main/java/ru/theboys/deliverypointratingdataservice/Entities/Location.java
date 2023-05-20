package ru.theboys.deliverypointratingdataservice.Entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "delivery-point-rating-db", name = "locations")
public class Location extends Model {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "paren-parent-location", referencedColumnName = "id")
    private Location parentLocation;

    private String name;

    private String coordinate;

    public Location(){

    }

    // ------- G/S -------
    public Location getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(Location parentLocation) {
        this.parentLocation = parentLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }
}
