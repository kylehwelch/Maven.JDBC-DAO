package dao;
import java.sql.*;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3360/jdbclab";
    public static final String USER = "kyle";
    public static final String PASS = "poooo";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }

}
