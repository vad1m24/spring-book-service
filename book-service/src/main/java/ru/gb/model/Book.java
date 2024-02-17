package ru.gb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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
