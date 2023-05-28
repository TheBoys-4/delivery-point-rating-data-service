package ru.theboys.deliverypointratingdataservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "message_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageType extends BaseModel {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}