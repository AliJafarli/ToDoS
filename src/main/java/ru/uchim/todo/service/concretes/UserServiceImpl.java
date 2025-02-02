package ru.uchim.todo.service.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.uchim.todo.entity.UserEntity;
import ru.uchim.todo.exceptions.BaseException;

import ru.uchim.todo.mapper.UserMapper;
import ru.uchim.todo.exceptions.constants.StatusCode;
import ru.uchim.todo.model.request.UserRequest;
import ru.uchim.todo.model.response.UserResponse;
import ru.uchim.todo.repository.UserRepository;
import ru.uchim.todo.service.abstracts.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {
        return UserMapper.mapToUserResponses(userRepository.findAll());
    }

    @Override
    public UserResponse getUserById(Long id) {
        return UserMapper.mapToUserResponse(this.userRepository.findById(id).orElseThrow(() -> new BaseException(HttpStatus.NOT_FOUND, StatusCode.USER_NOT_FOUND)));
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        UserEntity userEntity = UserMapper.mapToEntity(userRequest);
        return UserMapper.mapToUserResponse(this.userRepository.save(userEntity));
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        return UserMapper.mapToUserResponse(this.userRepository.save(UserMapper.mapToEntity(userRequest)));
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
