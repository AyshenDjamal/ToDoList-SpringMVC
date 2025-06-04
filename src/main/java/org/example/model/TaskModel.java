package org.example.model;

public class TaskModel {
    private int id;
    private String description;
    private String deadline;
    private boolean isDone;
    private int userID;

    public TaskModel(int id, String description, String deadline, boolean isDone, int userID){
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.isDone = isDone;
        this.userID = userID;
    }

    public TaskModel(String description, String deadline, int userID) {
        this.description = description;
        this.deadline = deadline;
        this.isDone = false; // default to not done
        this.userID = userID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
