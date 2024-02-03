package ru.gb.springbookservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * Запись о факте выдачи книги (в БД)
 */
@Data
@Entity
@Table(name = "issues")
@Schema(name = "Выдача")
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
