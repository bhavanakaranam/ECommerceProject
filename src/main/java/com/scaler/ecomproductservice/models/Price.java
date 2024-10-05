package com.scaler.ecomproductservice.models;

import jakarta.persistence.Entity;
import lombok.Data;


@Data
@Entity(name = "ECOM_PRICE")
public class Price extends BaseModel
{
    private String Currency;

    private double amount;

    private double discount;
}
