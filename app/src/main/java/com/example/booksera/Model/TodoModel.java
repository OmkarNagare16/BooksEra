package com.example.booksera.Model;

public class TodoModel extends Taskid{

    private String due;
    private int status;
    private String task;
    private String username;
    public String getDue() {
        return due;
    }

    public String getUsername() {
        return username;
    }

   public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public String getTask() {
        return task;
    }
}
