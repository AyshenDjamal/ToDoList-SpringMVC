package org.example.repository;

import org.example.config.DatabaseConnection;
import org.example.model.TaskModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public static void insertTasks(TaskModel taskModel){
        String sql = "INSERT INTO tasks (description, deadline, user_id) VALUES (?, ?, ?)";

        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ){
            pstmt.setString(1, taskModel.getDescription());
            pstmt.setString(2, taskModel.getDeadline());
           // pstmt.setBoolean(3, taskModel.getIsDone());
            pstmt.setInt(3, taskModel.getUserID());

            pstmt.executeUpdate();

        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static List<TaskModel> getTasksByUserId(int userID){
        List <TaskModel> taskModelList = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE user_id = ?";

        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                TaskModel newTaskModel = new TaskModel(
                 rs.getString("description"),
                 rs.getString("deadline"),
                 rs.getInt("user_id")
                );
                taskModelList.add(newTaskModel);
            }
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return taskModelList;
    }


}
