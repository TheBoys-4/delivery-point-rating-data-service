package ru.theboys.deliverypointratingdataservice.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Client extends BaseModel {

    private String name;

    @Column(name = "phone-number")
    private String phoneNumber;
    @Column(name = "e-mail")
    private String email;

    private String sex;

    private int age;


}
