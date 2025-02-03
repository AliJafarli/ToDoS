package ru.uchim.todo.model.request;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.uchim.todo.entity.TaskEntity;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserRequest {

    @Size(min = 2, max = 50)
    private String username;

    @Email(message = "Email format not match")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "password not match with pattern")
    private String password;


}

