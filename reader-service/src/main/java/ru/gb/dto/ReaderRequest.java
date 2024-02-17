package ru.gb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReaderRequest {

    private String name;

    public ReaderRequest(String name) {
        this.name = name;
    }
}