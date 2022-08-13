package dao;
import java.sql.*;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/jdbclab?verifyServerCertificate=false&useSSL=true";
    public static final String USER = "kwelch";
    public static final String PASS = "Engine#9!";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database Noooo", ex);
        }
    }

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }

}
