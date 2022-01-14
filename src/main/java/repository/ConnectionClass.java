package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    private Connection connection;
    private static ConnectionClass connectionClass;
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "admin";
    private ConnectionClass(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static ConnectionClass getInstance(){
        try {
            if (connectionClass == (null)){
                return connectionClass = new ConnectionClass();
            }
            else if (connectionClass.getConnection().isClosed()){
                return connectionClass = new ConnectionClass();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connectionClass;
    }

    public Connection getConnection() {
        return connection;
    }
}
