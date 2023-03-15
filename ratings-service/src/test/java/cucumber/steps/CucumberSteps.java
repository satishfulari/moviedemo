package cucumber.steps;

import com.movie.entity.MovieSummary;
import com.movie.entity.Rating;
import com.movie.entity.UserRating;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CucumberSteps {

    public UserRating userRating = UserRating.builder().build();
    public MovieSummary movieSummary = MovieSummary.builder().build();

    @Given("^that the user (.*) has given ratings to movie (.*)$")
    public void rateMovie(String userName, String movieName) throws Throwable {
        userRating.setUserId(userName);
        Rating rating = Rating.builder().movieId(movieName).build();
        userRating.setRatings(Arrays.asList(rating));
    }

    @When("^Movie (.*) is released in (\\d+)$")
    public void setMovieInfo(String movieName, int releaseYear) throws Throwable {
        movieSummary.setReleaseYear(releaseYear);
        movieSummary.setName(movieName);
    }

    @Then("^(.*) has given ratings for the movie (.*)$")
    public void checkMovieRated(String userName, String movieName) throws Throwable {
        assertThat(userName, equalTo(userRating.getUserId()));
        assertThat(movieSummary.getName(), equalTo(movieName));
    }
}