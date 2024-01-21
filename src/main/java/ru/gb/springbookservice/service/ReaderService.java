package ru.gb.springbookservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbookservice.dto.ReaderRequest;
import ru.gb.springbookservice.model.Issue;
import ru.gb.springbookservice.model.Reader;
import ru.gb.springbookservice.repository.ReaderRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final IssueService issueService;


    public List<Reader> getAll() {
        return readerRepository.getAll();
    }

    public Reader getReaderById(long id) {
        return readerRepository.getReaderById(id);
    }

    public Reader addReader(ReaderRequest readerRequest) {
        return readerRepository.addReader(new Reader(readerRequest.getName()));
    }

    public void deleteReaderById(long id) {
        readerRepository.deleteReaderById(id);
    }

    public Set<Issue> getIssuesByReaderId(long readerId) {
        return issueService.getIssuesByReaderId(readerId);
    }
}
