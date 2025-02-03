package ru.uchim.todo.exceptions.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCode {

    USER_NOT_FOUND(1004,"Error: User Not Found"),
    TASK_NOT_FOUND(1005,"Error: Task Not Found"),
    USER_ALREADY_EXIST(1006,"Error: User Already Exist"),
    FIELED_ERROR(1007,"Error: Field Error"),;


    private final int statusCode;
    private final String message;
}
