package com.scaler.ecomproductservice.repositories;

import com.scaler.ecomproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>
{
    Product findByTitle(String title);

    Optional<Product> findById(UUID id);

    Product findByTitleAndDescription(String ttile, String description);

    Product findByTitleOrDescription(String ttile, String description);

    @Query(value = CustomQueries.FINDBYTITLELIKE, nativeQuery = true)
    Product findByTitleLike(String title);
}
