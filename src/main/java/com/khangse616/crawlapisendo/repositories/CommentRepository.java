package com.khangse616.crawlapisendo.repositories;

import com.khangse616.crawlapisendo.models.Comment;
import com.khangse616.crawlapisendo.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
}
