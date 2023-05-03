package com.example.ratingsservice.repositories;

import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.RatingProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {

    List<RatingProjection> findByUserID(Integer userID);
}
