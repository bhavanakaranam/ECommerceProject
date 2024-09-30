package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService
{

    @Override
    public ProductResponseDTO getProduct(int productId) {
        return null;
    }

    @Override
    public ProductListResponseDTO getProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, int productId) {
        return null;
    }

}
