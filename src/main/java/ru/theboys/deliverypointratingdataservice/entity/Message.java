package ru.theboys.deliverypointratingdataservice.entity;

import ru.theboys.deliverypointratingdataservice.enums.MessageSource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message extends BaseModel {
    private Date dateTime;

    private int score;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    private Vendor vendor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_type_id", referencedColumnName = "id")
    private MessageType messageType;
    
    @Enumerated(EnumType.ORDINAL)
    private MessageSource messageSource;

    private String text;
}
