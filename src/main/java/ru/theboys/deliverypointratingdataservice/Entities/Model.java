package ru.theboys.deliverypointratingdataservice.Entities;

import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public abstract class Model implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;

    // ------- G/S -------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
