package com.example.SpringBootOpenApi.service.task;

import com.example.SpringBootOpenApi.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskEntity find() {
        return taskRepository.select()
                .map(record -> new TaskEntity(record.getId(), record.getTitle()))
                .orElseThrow(() -> new IllegalStateException("TODO"));
    }
}
