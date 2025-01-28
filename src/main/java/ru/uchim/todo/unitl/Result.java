package ru.uchim.todo.unitl;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Result<T> {
    private List<T> data;
    private int page;
    private int size;
    private int totalPages;
}
