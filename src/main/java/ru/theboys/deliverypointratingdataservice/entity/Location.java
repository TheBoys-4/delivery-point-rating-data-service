package ru.theboys.deliverypointratingdataservice.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import ru.theboys.deliverypointratingdataservice.enums.LocationType;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of={"id","name","coordinate"})
public class Location extends BaseModel {
    private String administrativeDistrict;
    private String district;
    private String address;
    private String coordinate;
    
    @Enumerated(EnumType.ORDINAL)
    private LocationType locationType;
}
