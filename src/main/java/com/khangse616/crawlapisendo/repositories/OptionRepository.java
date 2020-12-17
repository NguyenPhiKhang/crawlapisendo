package com.khangse616.crawlapisendo.repositories;

import com.khangse616.crawlapisendo.models.Image;
import com.khangse616.crawlapisendo.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {
    List<Option> findByIdIn(List<Integer> id);
}
