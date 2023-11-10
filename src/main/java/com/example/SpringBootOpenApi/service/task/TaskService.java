package com.example.SpringBootOpenApi.service.task;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    public TaskEntity find() {
        return new TaskEntity(2, "from Service");
    }
}
