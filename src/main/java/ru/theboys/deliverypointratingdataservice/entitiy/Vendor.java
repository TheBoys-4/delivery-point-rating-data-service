package ru.theboys.deliverypointratingdataservice.entitiy;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "elements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vendor extends BaseModel {

    private String name;

}
