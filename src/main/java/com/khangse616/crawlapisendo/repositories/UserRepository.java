package com.khangse616.crawlapisendo.repositories;

import com.khangse616.crawlapisendo.models.Image;
import com.khangse616.crawlapisendo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsById(int id);
    boolean existsByIdAndShopTrue(int id);
    boolean existsByIdAndName(int id, String name);
}
