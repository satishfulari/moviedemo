package com.movie;

import com.movie.entity.Rating;
import com.movie.entity.RatingsData;
import com.movie.entity.UserRating;
import com.movie.rating.jpa.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataService {

    @Autowired
    private RatingRepository ratingRepo;

    @GetMapping("/allRatings")
    public List<RatingsData> getAllRatings() {
        return ratingRepo.findAll();
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Rating>> getRatingsByMovieId(@RequestParam(value = "movieId") String movieId) {

        try {
            List<RatingsData> queryRes = ratingRepo.getRatingsByMovieId(movieId);

            List<Rating> ratings = new ArrayList<>();

            queryRes.forEach(entry -> ratings.add(Rating.builder().movieId(entry.getMovieId()).rating(entry.getUserRating()).build()));

            return ResponseEntity.ok().body(ratings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ArrayList<>());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<UserRating> getAllUserRatings(@RequestParam(value = "userId") String userId) {

        try {
            List<RatingsData> queryRes = ratingRepo.getRatingsByUserId(userId);

            List<Rating> ratings = new ArrayList<>();

            queryRes.forEach(entry -> ratings.add(Rating.builder().movieId(entry.getMovieId()).rating(entry.getUserRating()).build()));

            return ResponseEntity.ok().body(UserRating.builder().userId(userId).ratings(ratings).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(UserRating.builder().userId(userId).build());
        }
    }

}
