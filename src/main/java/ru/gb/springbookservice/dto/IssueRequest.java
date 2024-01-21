package ru.gb.springbookservice.dto;

import lombok.Data;

/**
 * Запрос на выдачу
 */
@Data
public class IssueRequest {

    /**
     * Идентификатор читателя
     */
    private long readerId;

    /**
     * Идентификатор книги
     */
    private long bookId;

}
