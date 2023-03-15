package com.movie.info.services;

import com.movie.entity.Celebrity;
import com.movie.entity.CelebritySummary;
import com.movie.entity.Movie;
import com.movie.entity.MovieSummary;
import com.movie.wrapper.EntityList;

import java.util.List;

public interface MovieInfoService {

    MovieSummary getMovieInfoById(Integer movieId);

    EntityList<Movie> searchMovieByName(String movieName);

    Celebrity searchByCelebrityName(String celebrityName);

    CelebritySummary getCelebrityInfoById(Integer celebrityId);

    Movie searchTvShowByName(String tvShowName);

    MovieSummary getTvShowInfoById(Integer tvShowId);

    EntityList<Celebrity> getAllCelebrities();

    EntityList<Movie> getAllMovies();

    EntityList<Movie> getAllTvShows();



}
