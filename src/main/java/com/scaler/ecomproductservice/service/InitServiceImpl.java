package com.scaler.ecomproductservice.service;

import com.scaler.ecomproductservice.models.Category;
import com.scaler.ecomproductservice.models.Order;
import com.scaler.ecomproductservice.models.Price;
import com.scaler.ecomproductservice.models.Product;
import com.scaler.ecomproductservice.repositories.CategoryRepository;
import com.scaler.ecomproductservice.repositories.OrderRepository;
import com.scaler.ecomproductservice.repositories.PriceRepository;
import com.scaler.ecomproductservice.repositories.ProductRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
public class InitServiceImpl implements InitService
{

    private ProductRepository productRepository;

    private OrderRepository orderRepository;

    private CategoryRepository categoryRepository;

    private PriceRepository priceRepository;

    public InitServiceImpl(ProductRepository productRepository, OrderRepository orderRepository,CategoryRepository categoryRepository,PriceRepository priceRepository)
    {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    @Override
    public void initialise()
    {
        Category electronics = new Category();
        electronics.setCategoryName("ELECTRONICS");

        // save the category to repository
        this.categoryRepository.save(electronics);

        Category apparelAccesories = new Category();
        apparelAccesories.setCategoryName("APPAREL ACCESORIES");

        this.categoryRepository.save(apparelAccesories);

        Product iphone = new Product();
        iphone.setTitle("IPhone 15 PRO");
        iphone.setDescription("Expensive phoone. Apple product.");

        Price iphonePrice = new Price();
        iphonePrice.setCurrency("INR");
        iphonePrice.setAmount(125000);
        iphonePrice.setDiscount(5);

        // Save iphonePrice to repository
        this.priceRepository.save(iphonePrice);

        // Set iphone price and category
        iphone.setPrice(iphonePrice);
        iphone.setCategory(electronics);
        iphone.setImage("DummyImageURL");

        Product handBag = new Product();
        handBag.setTitle("HandBag");
        handBag.setDescription("Gucci handbag");
        handBag.setCategory(apparelAccesories);
        handBag.setImage("DummyImageURL");

        Price handbagPrice = new Price();
        handbagPrice.setCurrency("INR");
        handbagPrice.setAmount(50000);
        handbagPrice.setDiscount(0);

        // Save handbag price to repository

        this.priceRepository.save(handbagPrice);

        handBag.setPrice(handbagPrice);

        this.productRepository.save(iphone);
        this.productRepository.save(handBag);

        Order order = new Order();
        order.setProducts(List.of(iphone, handBag));

        this.orderRepository.save(order);
    }
}
