package ru.gb.springbookservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Запрос на выдачу
 */
@Data
@NoArgsConstructor
public class IssueRequest {

    /**
     * Идентификатор читателя
     */
    private long readerId;

    /**
     * Идентификатор книги
     */
    private long bookId;

    public IssueRequest(long readerId, long bookId) {
        this.readerId = readerId;
        this.bookId = bookId;
    }
}
