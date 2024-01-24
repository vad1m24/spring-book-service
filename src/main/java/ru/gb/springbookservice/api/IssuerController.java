package ru.gb.springbookservice.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbookservice.dto.IssueRequest;
import ru.gb.springbookservice.exceptions.ConflictException;
import ru.gb.springbookservice.model.Issue;
import ru.gb.springbookservice.service.IssueService;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
public class IssuerController {

    @Autowired
    private IssueService service;

    @PostMapping
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

    @GetMapping
    public List<Issue> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Issue getIssueById(@PathVariable long id) {
        return service.getIssueById(id);
    }

}
