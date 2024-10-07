package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exceptions.ProductNotFoundException;

public interface ProductService
{
    public ProductResponseDTO getProductByTitle(String title) throws ProductNotFoundException;

    public ProductResponseDTO getProduct(int productId) throws ProductNotFoundException;

    public ProductListResponseDTO getProducts();

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    public boolean deleteProduct(int productId);

    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, int productId);
}
