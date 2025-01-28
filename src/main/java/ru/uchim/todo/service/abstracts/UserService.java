package ru.uchim.todo.service.abstracts;

import org.apache.catalina.User;
import ru.uchim.todo.model.request.UserRequest;
import ru.uchim.todo.model.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse saveUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest);
    void deleteUser(Long id);
}
