package kingstech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DATABASE_URL = "jdbc:sqlite:database.db";

    @SuppressWarnings("exports")
    public static Connection connectDb() {
        Connection connect = null;
        try {
            // Explicitly load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Attempt to establish a connection to the SQLite database
            connect = DriverManager.getConnection(DATABASE_URL);
            if (connect != null) {
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (ClassNotFoundException e) {
            // Handle the exception when the JDBC driver class is not found
            System.err.println("SQLite JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to connect to the SQLite database.");
            e.printStackTrace(); // This will print the stack trace to help with debugging
        }
        return connect;
    }
}
