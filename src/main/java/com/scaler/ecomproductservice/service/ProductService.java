package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exceptions.InvalidTitleException;
import com.scaler.ecomproductservice.exceptions.ProductNotFoundException;

import java.util.UUID;

public interface ProductService
{
    public ProductResponseDTO getProductByTitle(String title) throws ProductNotFoundException, InvalidTitleException;

    public ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException;

    public ProductListResponseDTO getProducts();

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    public boolean deleteProduct(UUID productId) throws ProductNotFoundException;

    public ProductResponseDTO updateProduct(UUID productId, ProductRequestDTO productRequestDTO)throws ProductNotFoundException;
}
