package dao;

import dto.Movie;

import java.sql.*;
import java.util.*;

public class MovieDAO {

    private Movie extractMovieFromResultSet(ResultSet rs) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getInt("id"));
        movie.setTitle(rs.getString("title"));
        movie.setGenre(rs.getString("genre"));
        movie.setRuntime(rs.getDouble("runtime"));
        movie.setRating(rs.getString("rating"));
        movie.setYear(rs.getInt("year"));
        return movie;
    }

    public Movie getMovie(int id) {
        Connection connection = ConnectionFactory.getConnection();
            try{
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM movies WHERE id =" + id);
                if (rs.next()){
                    return extractMovieFromResultSet(rs);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        return null;
    }

    public List getAllMovies() {
        Connection connection = ConnectionFactory.getConnection();
        try { Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
            List movies = new ArrayList();
            while(rs.next()){
                Movie movie = extractMovieFromResultSet(rs);
                movies.add(movie);
            }
            return movies;
        } catch (SQLException ex) {ex.printStackTrace();}
        return null;
    }

    public boolean addMovie(Movie movie) {
        Connection connection = ConnectionFactory.getConnection();
        try { PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO movies VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, movie.getId());
            ps.setString(2, movie.getTitle());
            ps.setString(3, movie.getGenre());
            ps.setDouble(4, movie.getRuntime());
            ps.setString(5, movie.getRating());
            ps.setInt(6, movie.getYear());
            int i = ps.executeUpdate();
            if (i == 1) {return true;}
        } catch (SQLException ex) {ex.printStackTrace();}
        return false;
    }

    public boolean updateMovie(Movie movie) {
        Connection connection = ConnectionFactory.getConnection();
        try { PreparedStatement ps = connection.prepareStatement(
                    "UPDATE movies SET title=?, genre=?, runtime=?, rating=?, year=? WHERE id=?");
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setDouble(3, movie.getRuntime());
            ps.setString(4, movie.getRating());
            ps.setInt(5, movie.getYear());
            ps.setInt(6, movie.getId());
            int i = ps.executeUpdate();
            if (i == 1) {return true;}
        } catch (SQLException ex) { ex.printStackTrace(); }
        return false;
    }

    public boolean deleteMovie (int id) {
        Connection connection = ConnectionFactory.getConnection();
        try { Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM movies WHERE id=" + id);
            if (i == 1) {return true;}
        } catch (SQLException ex) { ex.printStackTrace(); }
        return false;
    }

}
