package com.scaler.ecomproductservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_ORDER")
public class Order extends BaseModel
{
    @ManyToMany
    private List<Product> products;
}
