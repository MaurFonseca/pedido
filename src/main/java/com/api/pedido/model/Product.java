package com.api.pedido.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;

    private String name;

    private String description;

    private double price;

    private String imgUrl;

    @Setter(AccessLevel.NONE)
    @Transient
    private Set<Category> categories = new HashSet<>();

    public Product(Long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }
}
