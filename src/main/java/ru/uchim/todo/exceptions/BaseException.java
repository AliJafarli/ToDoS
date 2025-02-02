package ru.uchim.todo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import ru.uchim.todo.exceptions.constants.StatusCode;

@Getter
public class BaseException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final StatusCode status;


    public BaseException(HttpStatus httpStatus, StatusCode status) {
        super(status.getMessage());
        this.httpStatus = httpStatus;
        this.status = status;
    }

}
