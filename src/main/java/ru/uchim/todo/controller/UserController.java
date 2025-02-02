package ru.uchim.todo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.uchim.todo.model.request.UserRequest;
import ru.uchim.todo.model.response.UserResponse;
import ru.uchim.todo.service.abstracts.UserService;


import java.util.List;

@Log4j2
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();

    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("save_user")
    public void saveUser(@Valid @RequestBody UserRequest userRequest) {
        log.info(userRequest);
        userService.saveUser(userRequest);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable UserRequest userRequest) {
        return userService.updateUser(userRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
