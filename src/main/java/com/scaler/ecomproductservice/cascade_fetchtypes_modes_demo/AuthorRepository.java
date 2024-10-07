package com.scaler.ecomproductservice.cascade_fetchtypes_modes_demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findById(long id);
}
