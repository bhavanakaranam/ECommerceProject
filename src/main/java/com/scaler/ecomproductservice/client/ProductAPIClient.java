package com.scaler.ecomproductservice.client;

import com.scaler.ecomproductservice.dto.*;

import java.util.List;
import java.util.UUID;

public interface ProductAPIClient
{
    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO productRequestDTO);

    public FakeStoreProductResponseDTO getProduct(UUID productId);

    public List<FakeStoreProductResponseDTO> getProducts();

    public boolean deleteProduct(UUID productId);
}
