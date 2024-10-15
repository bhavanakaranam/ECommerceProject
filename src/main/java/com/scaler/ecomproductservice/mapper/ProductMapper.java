package com.scaler.ecomproductservice.mapper;

import com.scaler.ecomproductservice.dto.*;
import com.scaler.ecomproductservice.models.Price;
import com.scaler.ecomproductservice.models.Product;

import java.util.List;

public class ProductMapper
{
    public static FakeStoreProductRequestDTO productRequestDTOtoFakeStoreProductRequestDTO(ProductRequestDTO productRequestDTO)
    {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setImageURL(productRequestDTO.getImage());
        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDTO fakeStoreProductResponseDTOtoProductResponseDTO(FakeStoreProductResponseDTO fakeStoreProductResponseDTO)
    {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImageURL());
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        return productResponseDTO;
    }

    public static ProductListResponseDTO convertProductsToProductListResponseDTO(List<Product> productList)
    {
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(Product product: productList)
        {
            ProductResponseDTO productResponseDTO = ProductMapper.convertProductToProductResponseDTO(product);
            productListResponseDTO.getProducts().add(productResponseDTO);
        }

        return productListResponseDTO;
    }

    public static ProductResponseDTO convertProductToProductResponseDTO(Product product)
    {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setCategory(product.getCategory().getCategoryName());
        productResponseDTO.setPrice(product.getPrice().getAmount());
        productResponseDTO.setImage(product.getImage());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());

        return productResponseDTO;
    }

    public static Product convertProductRequestDTOToProduct(ProductRequestDTO productRequestDTO)
    {
        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setDescription(productRequestDTO.getDescription());
        Price price = new Price();
        price.setCurrency("INR");
        price.setDiscount(0);
        price.setAmount(productRequestDTO.getPrice());
        product.setPrice(price);
        product.setImage(productRequestDTO.getImage());

        return product;
    }
}
