package com.scaler.ecomproductservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDTO
{
    private String title;

    private String description;

    private double price;

    private String category;

    private String imageURL;
}
