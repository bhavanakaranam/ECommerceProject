package com.scaler.ecomproductservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO
{

    private String title;

    private String description;

    private String category;

    private double price;

    private String image;

}
