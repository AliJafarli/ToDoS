package ru.uchim.todo.service.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.uchim.todo.entity.TaskEntity;
import ru.uchim.todo.exceptions.BaseException;
import ru.uchim.todo.exceptions.constants.StatusCode;
import ru.uchim.todo.mapper.TaskMapper;
import ru.uchim.todo.model.request.TaskRequest;
import ru.uchim.todo.model.response.TaskResponse;
import ru.uchim.todo.repository.TaskRepository;
import ru.uchim.todo.service.abstracts.TaskService;
import ru.uchim.todo.model.result.Result;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;


    @Override
    public Result<TaskResponse> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<TaskEntity> tasks = taskRepository.findAll(pageable);
        List<TaskResponse> taskResponses = tasks.stream().map((t) -> TaskMapper.toTaskResponse(t)).toList();

        return new Result<>(taskResponses, page, size, tasks.getTotalPages());
    }

    @Override
    public TaskResponse findTaskById(Long id) {
        return TaskMapper.toTaskResponse(taskRepository.findById(id).orElseThrow(() -> new BaseException(HttpStatus.NOT_FOUND, StatusCode.TASK_NOT_FOUND)));
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        TaskEntity taskEntity = TaskMapper.toUserEntity(taskRequest);
        return TaskMapper.toTaskResponse(taskRepository.save(taskEntity));

    }

    @Override
    public TaskResponse updateTask(long id, TaskRequest taskRequest) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        TaskMapper.updateTask(taskEntity, taskRequest);
        return TaskMapper.toTaskResponse(taskRepository.save(taskEntity));
    }

    @Override
    public void deleteTaskById(Long id) {
        if(taskRepository.deleteByTaskId(id) == 0){
            throw new BaseException(HttpStatus.NOT_FOUND, StatusCode.TASK_NOT_FOUND);
        }
    }
}
