package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name ="product")
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingredients_gen")
    @SequenceGenerator(
            name = "ingredients_gen",
            sequenceName = "ingredients_seq",
            allocationSize = 1
    )
@Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "currentPrice")
    private double currentPrice;

    public Product( String name, double currentPrice) {
        this.name = name;
        this.currentPrice = currentPrice;
    }
    public Product( Long id,String name, double currentPrice) {
        this.id=id;
        this.name = name;
        this.currentPrice = currentPrice;
    }



    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }
}

