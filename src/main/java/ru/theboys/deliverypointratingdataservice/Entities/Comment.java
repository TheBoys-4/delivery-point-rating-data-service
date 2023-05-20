package ru.theboys.deliverypointratingdataservice.Entities;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(schema = "delivery-point-rating-db",name = "comments")
public class Comment extends Model {


    private Date dateTime;

    private int score;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "locationID", referencedColumnName = "id")
    private Location location;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "elementID", referencedColumnName = "id")
    private Element element;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "clientID", referencedColumnName = "id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "domainID", referencedColumnName = "id")
    private Domain domain;

    private String text;

    private BigDecimal price;

    // ------- contructors -------
    public Comment(Date dateTime, int score, Location location, Element element,
                   Client client, Domain domain, String text, BigDecimal price) {
        this.dateTime = dateTime;
        this.score = score;
        this.location = location;
        this.element = element;
        this.client = client;
        this.domain = domain;
        this.text = text;
        this.price = price;
    }

    public Comment(){
    }

    // ------- G/S -------
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
