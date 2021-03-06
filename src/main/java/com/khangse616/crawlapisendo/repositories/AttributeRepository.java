package com.khangse616.crawlapisendo.repositories;

import com.khangse616.crawlapisendo.models.Attribute;
import com.khangse616.crawlapisendo.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
}
