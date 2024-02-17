package ru.gb.api;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {

    private Long id;
    private Long bookId;
    private Long readerId;
    private LocalDateTime timestamp;

}
