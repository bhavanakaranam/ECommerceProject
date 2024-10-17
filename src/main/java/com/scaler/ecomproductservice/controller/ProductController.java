package com.scaler.ecomproductservice.controller;

import com.scaler.ecomproductservice.dto.ProductListResponseDTO;
import com.scaler.ecomproductservice.dto.ProductRequestDTO;
import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exceptions.ProductNotFoundException;
import com.scaler.ecomproductservice.models.Product;
import com.scaler.ecomproductservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProductController
{
    private ProductService productService;

    public ProductController(@Qualifier("productService") ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID productId) throws ProductNotFoundException
    {
        ProductResponseDTO response = productService.getProduct(productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/title/{title}")
    public ResponseEntity getProductByTitle(@PathVariable("title") String title) throws ProductNotFoundException
    {
        ProductResponseDTO response = productService.getProductByTitle(title);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products")
    public ResponseEntity getProducts()
    {
        ProductListResponseDTO response = productService.getProducts();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products/createProduct")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO responseDTO = this.productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/products/deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id) throws ProductNotFoundException
    {
        return ResponseEntity.ok(this.productService.deleteProduct(id));
    }

    @PatchMapping("/products/updateProduct/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody ProductRequestDTO productRequestDTO) throws ProductNotFoundException
    {
        ProductResponseDTO responseDTO = this.productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
