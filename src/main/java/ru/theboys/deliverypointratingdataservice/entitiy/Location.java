package ru.theboys.deliverypointratingdataservice.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location extends BaseModel {
    enum LocationType {
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "paren-parent-location", referencedColumnName = "id")
    private Location parentLocation;

    private String name;

    private String coordinate;
    @Enumerated(EnumType.ORDINAL)
    private LocationType locationType;


}
