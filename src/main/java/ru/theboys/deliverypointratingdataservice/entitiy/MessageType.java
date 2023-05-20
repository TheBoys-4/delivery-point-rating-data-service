package ru.theboys.deliverypointratingdataservice.entitiy;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "message_main_type", referencedColumnName = "id")
    private MessageMainType messageMainType;
}
