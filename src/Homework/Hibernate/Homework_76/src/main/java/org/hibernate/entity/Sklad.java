package org.hibernate.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sklad")
public class Sklad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @Column(name="city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name="square")
    private int square;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "sklad")
    private List<Good> goods;

    public Sklad() {
    }

    public Sklad(String city, String address, int square) {
        this.city = city;
        this.address = address;
        this.square = square;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getSquare() {
        return square;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Sklad{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", address=" + address +
                ", square=" + square +
                '}';
    }

    public void addGoodToSklad(Good good) {
        if(this.goods == null) {
            this.goods = new ArrayList<Good>();
        }
        goods.add(good);
        good.setSklad(this);
    }
}
