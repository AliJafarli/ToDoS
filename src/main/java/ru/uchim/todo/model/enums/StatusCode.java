package ru.uchim.todo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCode {
    USER_NOT_FOUND(1004,"Error: User Not Found"),
    BOOK_NOT_FOUND(1005,"Error: Book Not Found");

    private final int statusCode;
    private final String message;
}
