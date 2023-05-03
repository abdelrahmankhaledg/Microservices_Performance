package org.example;


import org.example.Rating;
import org.example.RatingProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    @Query("SELECT new Ratings(AVG(r.rating,r.movieId)) FROM Rating as r GROUP BY r.userID ORDER BY AVG(r.rating) LIMIT 10")
    public List<Ratings> topTen();
    List<RatingProjection> findByUserID(Integer userID);
}
