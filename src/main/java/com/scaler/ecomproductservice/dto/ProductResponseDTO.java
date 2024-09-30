package com.scaler.ecomproductservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO
{
    private int id;

    private String title;

    private String description;

    private String category;

    private double price;

    private String image;
}
