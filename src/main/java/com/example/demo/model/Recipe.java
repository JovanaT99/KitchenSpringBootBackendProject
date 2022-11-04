package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Recipe {
    @SequenceGenerator(
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )
    private Long id;
    private String name;
    private int difficulty;
    @ManyToMany
    @JoinColumn(
            name="product_id"
    )
    private List<Product>products;


}
