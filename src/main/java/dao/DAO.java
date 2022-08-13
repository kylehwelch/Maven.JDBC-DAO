package dao;

import dto.Movie;
import java.util.List;

public interface DAO {
    Movie getMovie();
    List<Movie> getAllMovies();
    Movie getMovieByNameAndId();
    boolean insertMovie();
    boolean updateMovie();
    boolean deleteMovie();
}
