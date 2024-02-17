package ru.gb.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.dto.IssueRequest;
import ru.gb.exceptions.ConflictException;
import ru.gb.model.Issue;
import ru.gb.service.IssueService;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
@Tag(name = "Выдачи")
public class IssuesController {

    @Autowired
    private IssueService service;

    @GetMapping
    @Operation(summary = "get all issues", description = "Получение списка всех выдач книг читателям")
    public List<Issue> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "get issue by id", description = "Получение выдачи книги по идентификационному номеру")
    public Issue getIssueById(@PathVariable long id) {
        return service.getIssueById(id);
    }

    @PostMapping
    @Operation(summary = "add a new issue of the book", description = "Создание новой выдачи книги читателю")
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());

        final Issue issue;
        try {
            issue = service.issue(request);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (ConflictException e) {
            return ResponseEntity.status(409).build();
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body(issue);
    }

}
