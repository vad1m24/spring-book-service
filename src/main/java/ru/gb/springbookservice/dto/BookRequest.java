package ru.gb.springbookservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookRequest {

    private String name;

    public BookRequest(String name) {
        this.name = name;
    }
}
