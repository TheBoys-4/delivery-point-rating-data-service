package ru.theboys.deliverypointratingdataservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RawMessage {
    private Date dateTime;

    private int score;

    private Location location;

    private Vendor vendor;

    private Client client;

    private String messageSource;

    private String text;
}
