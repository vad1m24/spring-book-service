package ru.gb.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.dto.ReaderRequest;
import ru.gb.model.Reader;
import ru.gb.repository.ReadersRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Class for test {@link ReaderService}
 */
@ExtendWith(MockitoExtension.class)
public class ReaderServiceTest {

    @Mock
    private ReadersRepository readerRepository;
    @InjectMocks
    private ReaderService readerService;

    @Test
    public void testAddReader() {
        when(readerRepository.save(any(Reader.class))).thenReturn(prepareReaders());

        Reader reader = readerService.addReader(prepareRequest());

        verify(readerRepository).save(any(Reader.class));
        assertEquals(reader, prepareReaders());
    }

    @Test
    public void testGetAllReaders() {
        when(readerRepository.findAll()).thenReturn(List.of(prepareReaders()));

        List<Reader> readers = readerService.getAll();

        verify(readerRepository).findAll();
        assertEquals(readers, List.of(prepareReaders()));
    }

    @Test
    public void testGetReaderById() {
        when(readerRepository.findById(1L)).thenReturn(Optional.of(prepareReaders()));

        Reader reader = readerService.getReaderById(1L);

        verify(readerRepository).findById(1L);
        assertEquals(reader, prepareReaders());
    }

    @Test
    public void testDeleteReaderById() {
        readerService.deleteReaderById(1L);
        verify(readerRepository).deleteById(1L);
    }


    private ReaderRequest prepareRequest() {
        return new ReaderRequest("name");
    }

    private Reader prepareReaders() {
        Reader reader = new Reader();
        reader.setId(1L);
        reader.setName("name");
        return reader;
    }
}
