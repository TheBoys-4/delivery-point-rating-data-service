package ru.theboys.deliverypointratingdataservice.Entities;

import jakarta.persistence.*;

@Entity
@Table(schema = "delivery-point-rating-db", name = "clients")
public class Client extends Model {

    private String name;

    @Column(name = "phone-number")
    private String phoneNumber;
    @Column(name = "e-mail")
    private String email;

    private String sex;

    private int age;

    // ------- contructors -------
    public Client(String name, String phoneNumber, String email, String sex, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sex = sex;
        this.age = age;
    }
    public Client(){
    }

    // ------- G/S -------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
