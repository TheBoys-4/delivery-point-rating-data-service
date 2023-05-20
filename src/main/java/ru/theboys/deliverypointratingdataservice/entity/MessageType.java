package ru.theboys.deliverypointratingdataservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.theboys.deliverypointratingdataservice.enums.MessageMainType;

@Entity
@Table(name = "message_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageType extends BaseModel {
    private String name;
    private MessageMainType messageMainType;
}
