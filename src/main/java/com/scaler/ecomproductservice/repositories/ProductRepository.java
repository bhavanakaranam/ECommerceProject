package com.scaler.ecomproductservice.repositories;

import com.scaler.ecomproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>
{
    Product findByTitle(String title);

    Product findByTtileAndDescription(String ttile, String description);

    Product findByTtileOrDescription(String ttile, String description);

    @Query(value = CustomQueries.FINDBYTITLELIKE, nativeQuery = true)
    Product findByTitleLike(String title);
}
