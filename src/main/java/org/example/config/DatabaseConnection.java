package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String URL = "jdbc:postgresql://localhost:5432/todo_list";
    private static String NAME = "postgres";
    private static String PASSWORD = "Admin";

    public static Connection connect(){
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
