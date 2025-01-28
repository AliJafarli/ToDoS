package ru.uchim.todo.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.uchim.todo.entity.UserEntity;

@Data
@Builder
@AllArgsConstructor
public class UserResponse  {
    private Long id;
    private String username;
    private String email;

}
