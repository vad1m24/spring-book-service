package ru.gb.springbookservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "books")
@Schema(name = "Книга")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Идентификационный номер книги")
    private Long id;

    @Column(name = "name")
    @Schema(name = "Имя")
    private String name;

    public Book(String name) {
        this.name = name;
    }
}
