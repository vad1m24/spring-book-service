package ru.gb.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dto.ReaderRequest;
import ru.gb.model.Reader;
import ru.gb.repository.ReadersRepository;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReadersRepository readerRepository;
//    private final IssueService issueService;


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

}
