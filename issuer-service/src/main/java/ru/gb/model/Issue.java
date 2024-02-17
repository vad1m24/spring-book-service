package ru.gb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "issues")
@NoArgsConstructor
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Идентификационный номер выдачи")
    private Long id;

    @Column(name = "bookId")
    @Schema(name = "Идентификационный номер книги")
    private Long bookId;

    @Column(name = "readerId")
    @Schema(name = "Идентификационный номер читателя")
    private Long readerId;

    @Schema(name = "Дата и время выдачи")
    private LocalDateTime timestamp;

    public Issue(long bookId, long readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.timestamp = LocalDateTime.now();
    }

}
