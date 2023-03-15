package com.movie;

import com.movie.entity.Item;
import com.movie.entity.Movie;
import com.movie.entity.MovieSummary;
import com.movie.entity.UserRating;
import com.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogsController {

    @Autowired
    private MovieService movieInfo;

//    @RequestMapping("/userRated")
//    public List<Item> getCatalog(@RequestParam("userId") String userid) {
//        UserRating ratings = movieInfo.getMovieByRating(userid)
//
//        return ratings.getRatings().stream().map(rating -> {
//                    Movie movie = movieInfo.getMovieByRating(rating);
//                    return Item.builder().name(movie.getName()).desc(movie.getOverview()).rating(rating.getRating()).build();
//                })
//                .collect(Collectors.toList());
//    }

    @RequestMapping("/searchMovie")
    public List<MovieSummary> getCatalog(@RequestParam("name") String name) {
        return movieInfo.getMovieInfo(Movie.builder().name(name).build());
    }


}
