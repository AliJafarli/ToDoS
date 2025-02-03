package ru.uchim.todo.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.uchim.todo.exceptions.BaseException;
import ru.uchim.todo.exceptions.constants.StatusCode;
import ru.uchim.todo.model.result.ErrorDataResult;
import ru.uchim.todo.model.result.ErrorResult;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestControllerAdvice
public class Handler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResult> handler(BaseException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorResult(e.getStatus().getStatusCode(), e.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResult> handleException(RuntimeException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResult(5000, e.getMessage()));
    }

    private void logError(String message, Exception e, WebRequest request) {
        log.error(message, request.getDescription(false), e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDataResult> handleFiledErrors(MethodArgumentNotValidException e) {

        List<String> errors = new ArrayList<>();
        e.getAllErrors().forEach(error -> {
            log.error(error.getDefaultMessage());
            errors.add(error.getDefaultMessage());
        });



        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDataResult(e.getMessage(), StatusCode.FIELED_ERROR, errors));
    }

}
