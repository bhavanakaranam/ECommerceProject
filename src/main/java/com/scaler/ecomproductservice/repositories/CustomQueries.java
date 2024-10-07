package com.scaler.ecomproductservice.repositories;

public interface CustomQueries
{
    public static final String FINDBYTITLELIKE = "select * from ECOM_PRODUCT where title like :title and id = :id";
}
