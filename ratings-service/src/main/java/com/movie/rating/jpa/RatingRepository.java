package com.movie.rating.jpa;

import com.movie.entity.RatingsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingsData, Integer> {

    @Query("select r from RatingsData r where r.movieId = :movieId")
    List<RatingsData> getRatingsByMovieId(String movieId);

    @Query("select r from RatingsData r where r.userId = :userId")
    List<RatingsData> getRatingsByUserId(String userId);

}
