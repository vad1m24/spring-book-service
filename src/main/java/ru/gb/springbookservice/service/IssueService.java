package ru.gb.springbookservice.service;

import lombok.*;
import org.springframework.stereotype.Service;
import ru.gb.springbookservice.dto.IssueRequest;
import ru.gb.springbookservice.exceptions.ConflictException;
import ru.gb.springbookservice.model.Issue;
import ru.gb.springbookservice.repository.BooksRepository;
import ru.gb.springbookservice.repository.IssuesRepository;
import ru.gb.springbookservice.repository.ReadersRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Data
@Service
@RequiredArgsConstructor
public class IssueService {

    // спринг это все заинжектит
    private final BooksRepository bookRepository;
    private final ReadersRepository readerRepository;
    private final IssuesRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.findById(request.getBookId()).isEmpty()) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.findById(request.getReaderId()).isEmpty()) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
        if (issueRepository.findById(request.getReaderId()).isPresent()) {
            throw new ConflictException("У читателя есть книги \"" + request.getReaderId() + "\"");
        }
        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public Issue getIssueById(long id) {
        return issueRepository.findById(id).orElse(null);
    }

    public Set<Issue> getIssuesByReaderId(long readerId) {
        return issueRepository.findIssuesByReaderId(readerId);
    }

    public List<Issue> getAll() {
        return issueRepository.findAll();
    }

}
