package com.movie.services;

import com.movie.entity.Movie;
import com.movie.entity.MovieSummary;
import com.movie.entity.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRatingService {

    @Autowired
    private RestTemplate restTemplate;

    public UserRating getMovieInfo(String userId) {
        return restTemplate.getForObject("http://ratings-service/ratingsdata/users/" + userId, UserRating.class);
    }

}
