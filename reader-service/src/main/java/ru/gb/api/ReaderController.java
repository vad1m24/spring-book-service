package ru.gb.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.gb.dto.ReaderRequest;
import ru.gb.model.Issue;
import ru.gb.model.Reader;
import ru.gb.service.ReaderService;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/reader")
@Tag(name = "Читатели")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping
    @Operation(summary = "get all readers", description = "Получение списка всех читателей")
    public List<Reader> getAll() {
        return readerService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "get reader by id", description = "Получение читателя по идентификационному номеру")
    public Reader getReaderById(@PathVariable long id) {
        return readerService.getReaderById(id);
    }

//    @GetMapping("/{readerId}/issue")
//    @Operation(summary = "get issue by reader's id", description = "Получение списка выдач по идентификационному номеру читателя")
//    public Set<Issue> getIssuesByReaderId(@PathVariable long readerId) {
//        return readerService.getIssuesByReaderId(readerId);
//    }

    @PostMapping
    @Operation(summary = "add a new reader", description = "Добавление нового читателя")
    public Reader addBook(@RequestBody ReaderRequest readerRequest) {
        return readerService.addReader(readerRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete reader by id", description = "Удаление читателя по идентификационному номеру")
    public void deleteReaderById(@PathVariable long id) {
        readerService.deleteReaderById(id);
    }
}
