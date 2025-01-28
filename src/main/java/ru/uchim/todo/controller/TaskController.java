package ru.uchim.todo.controller;

import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.uchim.todo.entity.TaskEntity;
import ru.uchim.todo.mapper.TaskMapper;
import ru.uchim.todo.model.request.TaskRequest;
import ru.uchim.todo.model.response.TaskResponse;
import ru.uchim.todo.service.abstracts.TaskService;
import ru.uchim.todo.service.concretes.TaskServiceImpl;
import ru.uchim.todo.unitl.Result;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

private final TaskService taskService;
private final TaskServiceImpl taskServiceImpl;

@GetMapping
public Result<TaskResponse> findAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size) {
    return taskServiceImpl.findAll(page, size);
}

@GetMapping("/{id}")
public TaskResponse findTaskById(@PathVariable Long id) {
    return taskService.findTaskById(id);
}

@PutMapping("/{id}")
public TaskResponse updateTaskById(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
    return taskService.updateTask(id, taskRequest);
}

@PostMapping("create_task")
public TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
    return taskService.createTask(taskRequest);
}

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteTaskById(@RequestParam Long id) {
    taskService.deleteTaskById(id);
}

}
