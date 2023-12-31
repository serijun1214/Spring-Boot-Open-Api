package com.example.SpringBootOpenApi.controller.task;

import com.example.SpringBootOpenApi.service.task.TaskEntity;
import com.example.SpringBootOpenApi.service.task.TaskService;
import com.example.todoapi.controller.TasksApi;
import com.example.todoapi.model.PageDTO;
import com.example.todoapi.model.TaskDTO;
import com.example.todoapi.model.TaskForm;
import com.example.todoapi.model.TaskListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TaskController implements TasksApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<TaskDTO> showTask(Long taskId) {
        var entity = taskService.find(taskId);
        var dto = toTaskDTO(entity);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<TaskDTO> createTask(TaskForm form) {
        var entity = taskService.create(form.getTitle());
        var dto = new TaskDTO();

        return ResponseEntity
                .created(URI.create("/tasks/" + dto.getId()))
                .body(dto);
    }

    @Override
    public ResponseEntity<TaskListDTO> listTasks(Long offset, Integer limit) {
        var entityList = taskService.find(limit, offset);
        var dtoList = entityList.stream()
                .map(TaskController::toTaskDTO)
                .collect(Collectors.toList());

        var pageDTO = new PageDTO();
        pageDTO.setLimit(limit);
        pageDTO.setOffset(offset);
        pageDTO.setSize(dtoList.size());

        var dto = new TaskListDTO();
        dto.setPage(pageDTO);
        dto.setResults(dtoList);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<TaskDTO> editTask(Long taskId, TaskForm taskForm) {
        var  Entity = taskService.update(taskId, taskForm.getTitle());
        var dto = toTaskDTO(Entity);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> deleteTask(Long taskId) {
        taskService.delete(taskId);
        return ResponseEntity.noContent().build();
    }

    private static TaskDTO toTaskDTO(TaskEntity taskEntity) {
        var taskDto = new TaskDTO();
        taskDto.setId(taskEntity.getId());
        taskDto.setTitle(taskEntity.getTitle());
        return taskDto;
    }
}
