package com.movie.info;

import com.movie.entity.Celebrity;
import com.movie.entity.CelebritySummary;
import com.movie.entity.Movie;
import com.movie.entity.MovieSummary;
import com.movie.info.services.MovieInfoService;
import com.movie.wrapper.EntityList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entertainment")
public class MovieSummaryController {

    @Autowired
    private MovieInfoService movieService;

    @GetMapping("/movieInfo")
    public List<MovieSummary> getMovieInfoByName(@RequestParam("movieName") String movieName) {
        EntityList<Movie> movieList = movieService.searchMovieByName(movieName);
        List<MovieSummary> movieSummary = new ArrayList<>();
        movieList.getObjectList().forEach(movie ->
                movieSummary.add(movieService.getMovieInfoById(movie.getId())));

        return movieSummary;
    }

    @GetMapping("/celebrityInfo")
    public CelebritySummary getCelebrityInfoByName(@RequestParam("celebrityName") String celebrityName) {
        Celebrity celeb = movieService.searchByCelebrityName(celebrityName);
        CelebritySummary celebSummary = movieService.getCelebrityInfoById(celeb.getId());
        return celebSummary;
    }

    @GetMapping("/tvShowInfo")
    public MovieSummary getTvShowInfoByName(@RequestParam("tvShowName") String tvShowName) {
        Movie movie = movieService.searchTvShowByName(tvShowName);
        MovieSummary movieSummary = movieService.getTvShowInfoById(movie.getId());
        return movieSummary;
    }

    @GetMapping("/allCelebrities")
    public EntityList<Celebrity> getAllCelebrities() {
        return movieService.getAllCelebrities();
    }

    @GetMapping("/allMovies")
    public EntityList<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/allTvShows")
    public EntityList<Movie> getAllTvShows() {
        return movieService.getAllTvShows();
    }

}
