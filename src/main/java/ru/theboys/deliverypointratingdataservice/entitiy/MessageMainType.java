package ru.theboys.deliverypointratingdataservice.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mesage_main_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageMainType extends BaseModel {
    private String name;

}
