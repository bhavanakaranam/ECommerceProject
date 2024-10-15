package com.scaler.ecomproductservice.client;

import com.scaler.ecomproductservice.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.scaler.ecomproductservice.mapper.ProductMapper.fakeStoreProductResponseDTOtoProductResponseDTO;

@Component
public class FakeStoreAPIClient implements ProductAPIClient
{

    private RestTemplateBuilder restTemplateBuilder;

    private String fakeStoreURL;

    private String fakeStoreProductsAPIPath;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}")String fakeStoreURL, @Value("${fakestore.api.path.product}")String fakeStoreProductsAPIPath)
    {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreURL = fakeStoreURL;
        this.fakeStoreProductsAPIPath = fakeStoreProductsAPIPath;
    }

    @Override
    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO productRequestDTO)
    {
        String url = this.fakeStoreURL+ this.fakeStoreProductsAPIPath;
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> responseDTO = restTemplate.postForEntity(url,productRequestDTO,FakeStoreProductResponseDTO.class);
        return responseDTO.getBody();
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(UUID productId) {
        String url = this.fakeStoreURL+ this.fakeStoreProductsAPIPath + "/" + productId;
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(
                url, FakeStoreProductResponseDTO.class);

        return productResponse.getBody();
    }

    @Override
    public List<FakeStoreProductResponseDTO> getProducts() {

        String url = this.fakeStoreURL+ this.fakeStoreProductsAPIPath;
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> products = restTemplate.getForEntity(url, FakeStoreProductResponseDTO[].class);
        List<FakeStoreProductResponseDTO> productListResponseDTO = new ArrayList<>();
        for(FakeStoreProductResponseDTO product: products.getBody())
        {
            productListResponseDTO.add(product);
        }

        return productListResponseDTO;
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        String url = this.fakeStoreURL+ this.fakeStoreProductsAPIPath + "/" + productId;
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        restTemplate.delete(url);
        return true;
    }

}
