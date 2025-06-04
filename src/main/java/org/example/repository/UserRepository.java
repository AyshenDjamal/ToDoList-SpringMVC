package org.example.repository;

import org.example.config.DatabaseConnection;
import org.example.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private static Connection conn = DatabaseConnection.connect();

    public static void insertUser(UserModel userModel) {
        String sql = "INSERT INTO users (full_name, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, userModel.getFullName());
            pstmt.setString(2, userModel.getEmail());
            pstmt.setString(3, userModel.getPassword());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean existsByEmail(String em) {
        String sql = "SELECT email FROM users";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                String email = rs.getString("email");
                if (em.equals(email)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public static boolean existsByEmailAndPassword(String em, String pass) {
        String sql = "SELECT email, password FROM users";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                if (em.equals(email) && pass.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public static Integer getUserIdByEmail(String email) {
        String sql = "SELECT id FROM users WHERE email = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
