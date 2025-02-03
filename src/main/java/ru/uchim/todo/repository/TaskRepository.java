package ru.uchim.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uchim.todo.entity.TaskEntity;
import ru.uchim.todo.model.response.TaskResponse;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    Integer deleteByTaskId(long id);

}
