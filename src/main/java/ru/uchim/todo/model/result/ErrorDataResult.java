package ru.uchim.todo.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uchim.todo.exceptions.constants.StatusCode;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDataResult {

    private String message;
    private StatusCode statusCode;
    private List<String> errors;

}
