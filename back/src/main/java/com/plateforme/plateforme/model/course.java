package com.plateforme.plateforme.model;

import jakarta.persistence.*;


@Entity
@Table(name = "courses")
public class course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String tiltle ;
    private  String description ;
    private int price;
    private  String period ;
    private  String image ;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public course(String tiltle, String description, int price, String image) {
        this.tiltle = tiltle;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public course() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTiltle() {
        return tiltle;
    }

    public void setTiltle(String tiltle) {
        this.tiltle = tiltle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
