package ru.gb.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dto.IssueRequest;
import ru.gb.exceptions.ConflictException;
import ru.gb.model.Issue;
import ru.gb.repository.IssuesRepository;
import ru.gb.utils.Timer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

@Data
@Service
@RequiredArgsConstructor
@Timer
public class IssueService {

    // спринг это все заинжектит
    private final BookProvider bookProvider;
//    private final ReadersRepository readerRepository;
    private final IssuesRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (Objects.isNull(bookProvider.getBookById(request.getBookId()))) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
//        if (readerRepository.findById(request.getReaderId()).isEmpty()) {
//            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
//        }
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
