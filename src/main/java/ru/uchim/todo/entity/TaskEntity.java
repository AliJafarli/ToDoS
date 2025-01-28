package ru.uchim.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.uchim.todo.model.enums.Priority;
import ru.uchim.todo.model.enums.TaskStatus;

@Entity
@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false)
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @CreationTimestamp
    private String createdAt;
    @UpdateTimestamp
    private String updatedAt;

    @ManyToOne
    private UserEntity user;



}
