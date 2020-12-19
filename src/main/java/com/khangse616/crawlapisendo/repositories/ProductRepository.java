package com.khangse616.crawlapisendo.repositories;

import com.khangse616.crawlapisendo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    @Query("select u.id, u.name, a.")
//    List<Object> joinProductWithImges();
}
