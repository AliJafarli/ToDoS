package ru.uchim.todo.mapper;

import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.config.Task;
import ru.uchim.todo.entity.TaskEntity;
import ru.uchim.todo.entity.UserEntity;
import ru.uchim.todo.model.request.TaskRequest;
import ru.uchim.todo.model.response.TaskResponse;

import java.util.List;
import java.util.stream.Collectors;

public interface TaskMapper {

    static TaskEntity toUserEntity(TaskRequest taskRequest) {
        return TaskEntity.builder().title(taskRequest.getTitle()).description(taskRequest.getDescription()).build();

    }

    static TaskResponse toTaskResponse(TaskEntity taskEntity) {
        return TaskResponse.builder().title(taskEntity.getTitle()).description(taskEntity.getDescription()).build();
    }

    static List<TaskResponse> toTaskResponseList(List<TaskEntity> taskEntities) {
        return taskEntities.stream().map(TaskMapper::toTaskResponse).collect(Collectors.toList());
    }

    static void updateTask(TaskEntity taskEntity, TaskRequest taskRequest) {
        taskEntity.setDescription(taskRequest.getDescription());
        taskEntity.setTitle(taskRequest.getTitle());
    }



}
