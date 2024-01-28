package ru.gb.springbookservice.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbookservice.dto.ReaderRequest;
import ru.gb.springbookservice.model.Issue;
import ru.gb.springbookservice.model.Reader;
import ru.gb.springbookservice.repository.ReadersRepository;

import java.util.List;
import java.util.Set;

@Data
@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReadersRepository readerRepository;
    private final IssueService issueService;


    public Reader addReader(ReaderRequest readerRequest) {
        return readerRepository.save(new Reader(readerRequest.getName()));
    }

    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    public Reader getReaderById(long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public void deleteReaderById(long id) {
        readerRepository.deleteById(id);
    }

    public Set<Issue> getIssuesByReaderId(long readerId) {
        return issueService.getIssuesByReaderId(readerId);
    }
}
