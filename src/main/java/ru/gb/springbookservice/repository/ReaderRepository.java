package ru.gb.springbookservice.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.springbookservice.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generateData() {
        readers.addAll(List.of(
                new ru.gb.springbookservice.model.Reader("Игорь"),
                new ru.gb.springbookservice.model.Reader("Дмитрий"),
                new ru.gb.springbookservice.model.Reader("Владимир")
        ));
    }

    public Reader getReaderById(long id) {
        return readers.stream().filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Reader addReader(Reader reader) {
        readers.add(reader);
        return reader;
    }

    public void deleteReaderById(long id) {
        readers.removeIf(it -> Objects.equals(it.getId(), id));
    }

    public List<Reader> getAll() {
        return readers;
    }
}
