package com.scaler.ecomproductservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PRODUCT")
public class Product extends BaseModel
{

    private String title;

    private String description;

    private int price;

    @ManyToOne
    private Category category;

    private String image;
}
