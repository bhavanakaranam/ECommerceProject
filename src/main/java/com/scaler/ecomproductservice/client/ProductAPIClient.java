package com.scaler.ecomproductservice.client;

import com.scaler.ecomproductservice.dto.*;

import java.util.List;

public interface ProductAPIClient
{
    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO productRequestDTO);

    public FakeStoreProductResponseDTO getProduct(int productId);

    public List<FakeStoreProductResponseDTO> getProducts();

    public boolean deleteProduct(int productId);
}
