package ru.uchim.todo.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.uchim.todo.exceptions.BaseException;
import ru.uchim.todo.model.result.ErrorResult;

@Slf4j
@RestControllerAdvice
public class Handler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResult> handleArithmeticException(BaseException e){
        log.error(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorResult(e.getStatus().getStatusCode(), e.getMessage()));
    }
@ExceptionHandler(RuntimeException.class)
public ResponseEntity<ErrorResult> handleException(RuntimeException e){
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResult(5000, e.getMessage()));
}

}
