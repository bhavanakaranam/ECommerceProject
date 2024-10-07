package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exceptions.ProductNotFoundException;
import com.scaler.ecomproductservice.mapper.ProductMapper;
import com.scaler.ecomproductservice.models.Product;
import com.scaler.ecomproductservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO getProductByTitle(String title) throws ProductNotFoundException
    {
        Product product = this.productRepository.findByTitle(title);
        return ProductMapper.convertProductToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO getProduct(int productId) {
        return null;
    }

    @Override
    public ProductListResponseDTO getProducts() {
        List<Product> allProducts = this.productRepository.findAll();
        return ProductMapper.convertProductsToProductListResponseDTO
                (allProducts);

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
