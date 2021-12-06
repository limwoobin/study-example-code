package moviebuddy.data;

import moviebuddy.MovieBuddyFactory;
import moviebuddy.MovieBuddyProfile;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(MovieBuddyFactory.class)
@ActiveProfiles(MovieBuddyProfile.XML_MODE)
@TestPropertySource(properties = "movie.metadata=movie_metadata.xml")
public class XmlMovieReaderTest {
    @Autowired
    MovieReader movieReader;

    @Test
    void NotEmpty_LoadedMovies() {
        List<Movie> movies = movieReader.loadMovies();
        Assertions.assertEquals(1375 , movies.size());
    }
}