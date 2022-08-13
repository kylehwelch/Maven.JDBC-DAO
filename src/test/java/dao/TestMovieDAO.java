package dao;

import dto.Movie;
import org.junit.*;

import java.sql.Array;
import java.util.*;

public class TestMovieDAO {

    MovieDAO md;

    @Before
    public void initialize() {
        md = new MovieDAO();
    }

    @Test
    public void testGetMovie(){
        Movie movie = new Movie();
        movie = md.getMovie(1);
        String actual = movie.getTitle();
        Assert.assertEquals("snatch", actual);
    }

    @Test
    public void testGetAllMovies(){
        List<Movie> movieList = md.getAllMovies();

        Assert.assertNotNull(movieList);
    }

    @Test
    public void testAddMovie(){
        Movie movie = new Movie(8,"waiting", "comedy", 1.7, "r", 2008);
        md.addMovie(movie);
        Movie newMovie = md.getMovie(8);
        String actual = newMovie.getTitle();
        Assert.assertEquals("waiting", actual);
    }

    @Test
    public void testUpdateMovie(){
        Movie movie = new Movie(8, "waiting", "comedy", 1.7, "r", 2005);
        md.updateMovie(movie);
        Movie alteredMovie = md.getMovie(8);
        int actual = alteredMovie.getYear();
        Assert.assertEquals(2005, actual);
    }

    @Test
    public void testDeleteMovie(){
        int expected = md.getAllMovies().size() - 1;
        md.deleteMovie(8);
        int actual = md.getAllMovies().size();
        Assert.assertEquals(expected, actual);
    }

}
