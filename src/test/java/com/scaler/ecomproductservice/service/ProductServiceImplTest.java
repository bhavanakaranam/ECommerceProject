package com.scaler.ecomproductservice.service;


import com.scaler.ecomproductservice.dto.ProductResponseDTO;
import com.scaler.ecomproductservice.exceptions.InvalidTitleException;
import com.scaler.ecomproductservice.exceptions.ProductNotFoundException;
import com.scaler.ecomproductservice.models.Category;
import com.scaler.ecomproductservice.models.Price;
import com.scaler.ecomproductservice.models.Product;
import com.scaler.ecomproductservice.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.when;

public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup()
    {
        System.out.println("Before each test");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindProductByTitle_Success() throws ProductNotFoundException, InvalidTitleException
    {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(1000);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("Mock Category");

        String testTitle = "Test Title";
        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("Test Description");
        mockProduct.setImage("Random image URL");
        mockProduct.setCategory(mockCategory);
        mockProduct.setPrice(mockPrice);

        when(productRepository.findByTitle(testTitle)).thenReturn(mockProduct);
        //Act
        ProductResponseDTO responseDTO = productService.getProductByTitle(testTitle);
        //Assert
        Assertions.assertEquals(mockProduct.getTitle(), responseDTO.getTitle());
        Assertions.assertEquals(mockProduct.getDescription(), responseDTO.getDescription());
        Assertions.assertEquals(mockProduct.getCategory().getCategoryName(), responseDTO.getCategory());
        Assertions.assertEquals(mockProduct.getId(), responseDTO.getId());
    }

    public void testFindProductByTitle_RepoRespondsWithNullObject()
    {
        String testTitle = "Test title";
        when(productRepository.findByTitle(testTitle)).thenReturn(null);
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.getProductByTitle(testTitle));
    }

    @Test
    public void testFindProductByTitle_NullTitle() throws ProductNotFoundException, InvalidTitleException
    {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(1000);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("Mock Category");

        String testTitle = null;
        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("Test Description");
        mockProduct.setImage("Random image URL");
        mockProduct.setCategory(mockCategory);
        mockProduct.setPrice(mockPrice);

        when(productRepository.findByTitle(testTitle)).thenReturn(mockProduct);
        //Act

        //Assert
        Assertions.assertThrows(InvalidTitleException.class, ()->productService.getProductByTitle(testTitle));
    }

    @Test
    public void testFindProductByTitle_EmptyTitle() throws ProductNotFoundException, InvalidTitleException
    {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(1000);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("Mock Category");

        String testTitle = "";
        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("Test Description");
        mockProduct.setImage("Random image URL");
        mockProduct.setCategory(mockCategory);
        mockProduct.setPrice(mockPrice);

        when(productRepository.findByTitle(testTitle)).thenReturn(mockProduct);
        //Act

        //Assert
        Assertions.assertThrows(InvalidTitleException.class, ()-> productService.getProductByTitle(testTitle));

    }


}
