package ru.theboys.deliverypointratingdataservice.Entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "delivery-point-rating-db", name = "elements")
public class Element extends Model{

    private String name;

    // ------- G/S -------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
