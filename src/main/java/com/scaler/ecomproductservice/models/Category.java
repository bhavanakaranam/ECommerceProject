package com.scaler.ecomproductservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ECOM_CATEGORY")
public class Category extends BaseModel
{
    public String categoryName;
}
