package org.internetstore.entity;

import jakarta.persistence.*;

@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String category;
    private int partNumber;
    private String name;
    private String model;
    private String country;
    private String weight;
    private String volume;
    private String price;

    @Column(length = 3000)
    private String description;

    private String image;

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }

    public String getWeight() {
        return weight;
    }

    public String getVolume() {
        return volume;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
