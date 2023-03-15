package com.movie.services;

import com.movie.entity.Movie;
import com.movie.entity.MovieSummary;
import com.movie.entity.Rating;
import com.movie.wrapper.EntityList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restApi;

    public Movie getMovieByRating(Rating rate){
        return restApi.getForObject("http://movie-info-service/entertainment/movies/" + rate.getMovieId(), Movie.class);
    }

    public List<MovieSummary> getMovieInfo(Movie movie){
        return restApi.getForObject("http://movie-info-service/entertainment/movieInfo&movieName=" + movie.getName(), EntityList.class).getObjectList();
    }

}
