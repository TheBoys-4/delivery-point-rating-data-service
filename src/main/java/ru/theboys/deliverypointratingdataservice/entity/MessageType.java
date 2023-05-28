package ru.theboys.deliverypointratingdataservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "message_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageType extends BaseModel {
    private String name;

}