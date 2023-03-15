package junittest;

import com.movie.entity.Movie;
import com.movie.entity.MovieSummary;
import com.movie.services.MovieService;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CatalogsControllerTest {

    @Mock
    private MovieService movieService;

    private List<MovieSummary> movieList;

    @Before
    public void setup(){
        //movieService = new MovieService();

        MovieSummary movie1 = MovieSummary.builder()
                .id(1)
                .name("The Avenger")
                .cast(Arrays.asList("Mark Ruffalo", "Robert Downey Jr"))
                .releaseYear(2012)
                .build();

        MovieSummary movie2 = MovieSummary.builder()
                .id(2)
                .name("The Shawshank Redemption")
                .cast(Arrays.asList("Morgan Freeman", "Tim Robbins"))
                .releaseYear(1994)
                .build();

        MovieSummary movie3 = MovieSummary.builder()
                .id(3)
                .name("The Godfather")
                .cast(Arrays.asList("Al Pacino", "Marlon Brando"))
                .releaseYear(1972)
                .build();

        movieList = Arrays.asList(movie1, movie2, movie3);
    }

    @DisplayName("JUnit test for getCatalog method to search Movie Name")
    @Test
    public void givenMovieName_whenGetCatalog_thenReturnMovieList() {
        // given - precondition or setup

        Movie mov = Movie.builder()
                .name("The")
                .build();

        given(movieService.getMovieInfo(mov)).willReturn(movieList);

        // when -  action or the behaviour that we are going test
        List<MovieSummary> movieSummaries = movieService.getMovieInfo(mov);

        // then - verify the output
        assertThat(movieSummaries).isNotNull();
        assertThat(movieSummaries.size()).isEqualTo(3);
    }

}
