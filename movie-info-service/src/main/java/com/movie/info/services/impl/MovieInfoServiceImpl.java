package com.movie.info.services.impl;

import com.movie.entity.Celebrity;
import com.movie.entity.CelebritySummary;
import com.movie.entity.Movie;
import com.movie.entity.MovieSummary;
import com.movie.info.services.MovieInfoService;
import com.movie.wrapper.EntityList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    @Value("api.key")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public EntityList<Movie> searchMovieByName(String movieName) {
        return restTemplate.getForObject(String.format("https://api.themoviedb.org/3/search/movie?api_key=%s&include_adult=false&query=%s", apiKey, movieName), EntityList.class);
    }

    @Override
    public MovieSummary getMovieInfoById(Integer movieId) {
        return restTemplate.getForObject(String.format("https://api.themoviedb.org/3/search/movie/%d?api_key=%s&include_adult=false", movieId, apiKey), MovieSummary.class);
    }

    @Override
    public Celebrity searchByCelebrityName(String celebrityName) {
        return restTemplate.getForObject(String.format("https://api.themoviedb.org/3/search/person?api_key=%s&include_adult=false&query=%s", apiKey, celebrityName), Celebrity.class);
    }

    @Override
    public CelebritySummary getCelebrityInfoById(Integer celebrityId) {
        return restTemplate.getForObject(String.format("https://api.themoviedb.org/3/search/person/%d?api_key=%s&include_adult=false", celebrityId, apiKey), CelebritySummary.class);
    }

    @Override
    public Movie searchTvShowByName(String tvShowName) {
        return restTemplate.getForObject(String.format("https://api.themoviedb.org/3/search/tv?api_key=%s&include_adult=false&query=%s", apiKey, tvShowName), Movie.class);
    }

    @Override
    public MovieSummary getTvShowInfoById(Integer tvShowId) {
        return restTemplate.getForObject(String.format("https://api.themoviedb.org/3/search/tv/%d?api_key=%s&include_adult=false", tvShowId, apiKey), MovieSummary.class);
    }

    @Override
    public EntityList<Celebrity> getAllCelebrities() {
        return restTemplate.getForObject(String.format("https://api.themoviedb.org/3/person/latest?api_key=%s&include_adult=false", apiKey), EntityList.class);
    }

    @Override
    public EntityList<Movie> getAllMovies() {
        return restTemplate.getForObject(String.format("https://api.themoviedb.org/3/movie/latest?api_key=%s&include_adult=false", apiKey), EntityList.class);
    }

    @Override
    public EntityList<Movie> getAllTvShows() {
        return restTemplate.getForObject(String.format("https://api.themoviedb.org/3/tv/latest?api_key=%s&include_adult=false", apiKey), EntityList.class);
    }
}
