package com.scaler.ecomproductservice.repositories;

import com.scaler.ecomproductservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>
{
    Optional<Category> findById(UUID id);

    Category findByCategoryName(String categoryName);
}
