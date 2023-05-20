package ru.theboys.deliverypointratingdataservice.Entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "delivery-point-rating-db", name = "domains")
public class Domain extends Model {

    private String name;




    // ------- G/S -------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
