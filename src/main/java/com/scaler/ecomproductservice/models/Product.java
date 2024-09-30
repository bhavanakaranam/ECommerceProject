package com.scaler.ecomproductservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product
{

    private String title;

    private String description;

    private int price;

    private String category;

    private String image;
}
