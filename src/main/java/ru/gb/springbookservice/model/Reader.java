package ru.gb.springbookservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "readers")
@Schema(name = "Читатель")
@NoArgsConstructor
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Идентификационный номер читателя")
    private long id;

    @Column(name = "name")
    @Schema(name = "Имя")
    private String name;

    public Reader(String name) {
        this.name = name;
    }
}

