package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.client.ProductAPIClient;
import com.scaler.ecomproductservice.dto.*;
import com.scaler.ecomproductservice.exceptions.ProductNotFoundException;
import com.scaler.ecomproductservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

import static com.scaler.ecomproductservice.mapper.ProductMapper.fakeStoreProductResponseDTOtoProductResponseDTO;
import static com.scaler.ecomproductservice.mapper.ProductMapper.productRequestDTOtoFakeStoreProductRequestDTO;
import static com.scaler.ecomproductservice.util.ProductUtils.isNull;

@Service("fakeProductService")
public class FakeProductServiceImpl implements ProductService
{

    private final RestTemplateBuilder restTemplateBuilder;

    private ProductAPIClient apiClient;

    public FakeProductServiceImpl(RestTemplateBuilder builder, ProductAPIClient apiClient)
    {
        this.restTemplateBuilder = builder;
        this.apiClient = apiClient;
    }

    @Override
    public ProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO response = this.apiClient.getProduct(productId);
        if(isNull(response))
            throw new ProductNotFoundException("Product with id "+productId+" not found.");
        return fakeStoreProductResponseDTOtoProductResponseDTO(response);
    }

    @Override
    public ProductListResponseDTO getProducts()
    {
        List<FakeStoreProductResponseDTO> productResponses = this.apiClient.getProducts();
        ProductListResponseDTO response = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO productResponse : productResponses)
        {
            response.getProducts().add(fakeStoreProductResponseDTOtoProductResponseDTO(productResponse));
        }
        return response;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO)
    {
        FakeStoreProductRequestDTO requestDTO = productRequestDTOtoFakeStoreProductRequestDTO(productRequestDTO);
        FakeStoreProductResponseDTO responseDTO = this.apiClient.createProduct(requestDTO);
        return fakeStoreProductResponseDTOtoProductResponseDTO(responseDTO);
    }

    @Override
    public boolean deleteProduct(int productId) {
        return this.apiClient.deleteProduct(productId);
    }

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, int productId)
    {
        return null;

    }
}

