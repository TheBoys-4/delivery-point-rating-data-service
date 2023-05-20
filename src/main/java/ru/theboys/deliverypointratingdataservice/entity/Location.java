package ru.theboys.deliverypointratingdataservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.theboys.deliverypointratingdataservice.enums.LocationType;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_location_id", referencedColumnName = "id")
    private Location parentLocation;

    private String name;

    private String coordinate;
    
    @Enumerated(EnumType.ORDINAL)
    private LocationType locationType;
}
