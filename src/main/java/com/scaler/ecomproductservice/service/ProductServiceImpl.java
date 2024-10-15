package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exceptions.ProductNotFoundException;
import com.scaler.ecomproductservice.mapper.ProductMapper;
import com.scaler.ecomproductservice.models.Category;
import com.scaler.ecomproductservice.models.Product;
import com.scaler.ecomproductservice.repositories.CategoryRepository;
import com.scaler.ecomproductservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductResponseDTO getProductByTitle(String title) throws ProductNotFoundException
    {
        Product product = this.productRepository.findByTitle(title);
        return ProductMapper.convertProductToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException
    {
        Optional<Product> product = this.productRepository.findById(productId);
        if(!product.isPresent())
            throw new ProductNotFoundException("Product with product "+productId+" not found exception");
        return ProductMapper.convertProductToProductResponseDTO(product.get());
    }

    @Override
    public ProductListResponseDTO getProducts()
    {
        List<Product> allProducts = this.productRepository.findAll();
        return ProductMapper.convertProductsToProductListResponseDTO
                (allProducts);

    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO)
    {
        Category category = this.categoryRepository.findByName(productRequestDTO.getCategory());
        Product product = ProductMapper.convertProductRequestDTOToProduct(productRequestDTO);
        product.setCategory(category);
        Product savedProduct = this.productRepository.save(product);
        return ProductMapper.convertProductToProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) throws ProductNotFoundException
    {
        Optional<Product> product = this.productRepository.findById(productId);
        if(!product.isPresent())
            throw new ProductNotFoundException("Product with id "+productId+" not found. Could not delete the product.");

        this.productRepository.delete(product.get());
        return true;
    }

    @Override
    public ProductResponseDTO updateProduct( UUID productId, ProductRequestDTO productRequestDTO) throws ProductNotFoundException
    {
        Optional<Product> product = this.productRepository.findById(productId);
        if(!product.isPresent())
            throw new ProductNotFoundException("Product with id "+productId+" not found. Could not delete the product.");

        Product updatedProduct = this.productRepository.save(product.get());
        return ProductMapper.convertProductToProductResponseDTO(updatedProduct);

    }

}
