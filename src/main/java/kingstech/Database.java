package kingstech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection connectDb() {
        Connection connect = null;
        try {
            // SQLite connection string
            String url = "jdbc:sqlite:database.db";
            connect = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }
}
