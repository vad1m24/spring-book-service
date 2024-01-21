package ru.gb.springbookservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbookservice.dto.IssueRequest;
import ru.gb.springbookservice.exceptions.ConflictException;
import ru.gb.springbookservice.model.Issue;
import ru.gb.springbookservice.repository.BookRepository;
import ru.gb.springbookservice.repository.IssueRepository;
import ru.gb.springbookservice.repository.ReaderRepository;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class IssueService {

    // спринг это все заинжектит
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
        if (!issueRepository.getIssuesByReaderId(request.getReaderId()).isEmpty()) {
            throw new ConflictException("У читателя есть книги \"" + request.getReaderId() + "\"");
        }
        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public Issue getIssueById(long id) {
        return issueRepository.getIssueById(id);
    }

    public Set<Issue> getIssuesByReaderId(long readerId) {
        return issueRepository.getIssuesByReaderId(readerId);
    }


}
