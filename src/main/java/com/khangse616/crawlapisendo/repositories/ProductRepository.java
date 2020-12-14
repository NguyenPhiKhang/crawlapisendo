package com.khangse616.crawlapisendo.repositories;

import com.khangse616.crawlapisendo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
