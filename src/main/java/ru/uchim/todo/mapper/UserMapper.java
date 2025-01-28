package ru.uchim.todo.mapper;

import org.apache.catalina.User;
import ru.uchim.todo.entity.UserEntity;
import ru.uchim.todo.model.request.UserRequest;
import ru.uchim.todo.model.response.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

public interface UserMapper {

    static UserResponse mapToUserResponse(UserEntity user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    static List<UserResponse> mapToUserResponses(List<UserEntity> users) {
        return users.stream().map(UserMapper::mapToUserResponse).toList();
    }
    static UserEntity mapToEntity(UserRequest userRequest){
        return UserEntity.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail()).password(userRequest.getPassword()).build();

    }

}


