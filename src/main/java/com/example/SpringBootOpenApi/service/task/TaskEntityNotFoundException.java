package com.example.SpringBootOpenApi.service.task;

public class TaskEntityNotFoundException extends RuntimeException {

    private long taskId;

    public TaskEntityNotFoundException(long taskId) {
        super("TskEntity (id = " + taskId + ") is not found.");
        this.taskId = taskId;
    }
}
