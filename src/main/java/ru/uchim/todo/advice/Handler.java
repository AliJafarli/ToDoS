package ru.uchim.todo.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.uchim.todo.exceptions.BaseException;
import ru.uchim.todo.model.result.ErrorResult;

import static ru.uchim.todo.exceptions.constants.StatusCode.USER_ALREADY_EXIST;

@Slf4j
@RestControllerAdvice
public class Handler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResult> handleUserAlreadyExistException(BaseException e){
        log.error(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorResult(e.getStatus().getStatusCode(), e.getMessage()));
    }
@ExceptionHandler(RuntimeException.class)
public ResponseEntity<ErrorResult> handleException(RuntimeException e){
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResult(5000, e.getMessage()));
}

private void logError(String message, Exception e, WebRequest request) {
        log.error(message, request.getDescription(false), e);
}

}
