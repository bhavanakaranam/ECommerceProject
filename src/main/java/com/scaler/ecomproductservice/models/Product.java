package com.scaler.ecomproductservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    private Category category;

    private String image;

}
