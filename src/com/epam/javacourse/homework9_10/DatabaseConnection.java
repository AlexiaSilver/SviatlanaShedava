package com.epam.javacourse.homework9_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\Sviatlana_Shedava\\.dbeaver4\\.metadata\\sample-database-sqlite-1\\Chinook.db";

    public static Connection getConnection() {
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(DB_URL);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
