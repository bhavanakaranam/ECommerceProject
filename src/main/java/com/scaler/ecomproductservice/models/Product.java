package com.scaler.ecomproductservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_PRODUCT")
public class Product extends BaseModel
{

    private String title;

    private String description;

    @OneToOne
    private Price price;

    @ManyToOne
    @JoinColumn(name = "ecom_category_id")
    private Category category;

    private String image;

}
