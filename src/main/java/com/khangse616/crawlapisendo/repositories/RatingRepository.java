package com.khangse616.crawlapisendo.repositories;

import com.khangse616.crawlapisendo.models.Image;
import com.khangse616.crawlapisendo.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
