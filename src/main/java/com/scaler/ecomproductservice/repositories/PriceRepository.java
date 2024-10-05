package com.scaler.ecomproductservice.repositories;

import com.scaler.ecomproductservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>
{
}
