package ru.uchim.todo.service.abstracts;

import ru.uchim.todo.model.request.TaskRequest;
import ru.uchim.todo.model.response.TaskResponse;
import ru.uchim.todo.model.result.Result;

public interface TaskService {

    Result<TaskResponse> findAll(int page, int size);
    TaskResponse findTaskById(Long id);
    TaskResponse createTask(TaskRequest taskRequest);
    TaskResponse updateTask(long id, TaskRequest taskRequest);
    void deleteTaskById(Long id);

}
