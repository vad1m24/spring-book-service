package ru.gb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IssueRequest {

    private long readerId;
    private long bookId;

    public IssueRequest(long readerId, long bookId) {
        this.readerId = readerId;
        this.bookId = bookId;
    }
}
