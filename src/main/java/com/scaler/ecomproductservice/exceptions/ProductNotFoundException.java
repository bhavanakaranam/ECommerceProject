package com.scaler.ecomproductservice.exceptions;

import com.scaler.ecomproductservice.controller.ProductController;

public class ProductNotFoundException extends Exception
{
    public ProductNotFoundException(String message)
    {
        super(message);
    }
}
