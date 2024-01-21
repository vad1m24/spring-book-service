package ru.gb.springbookservice.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbookservice.dto.ReaderRequest;
import ru.gb.springbookservice.model.Issue;
import ru.gb.springbookservice.model.Reader;
import ru.gb.springbookservice.service.ReaderService;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping
    public List<Reader> getAll() {
        return readerService.getAll();
    }

    @GetMapping("/{id}")
    public Reader getReaderById(@PathVariable long id) {
        return readerService.getReaderById(id);
    }

    @PostMapping
    public Reader addBook(@RequestBody ReaderRequest readerRequest) {
        return readerService.addReader(readerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteReaderById(@PathVariable long id) {
        readerService.deleteReaderById(id);
    }

    @GetMapping("/{readerId}/issue")
    public Set<Issue> getIssuesByReaderId(@PathVariable long readerId) {
        return readerService.getIssuesByReaderId(readerId);
    }
}
