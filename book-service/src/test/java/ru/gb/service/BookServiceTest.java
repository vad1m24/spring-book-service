package ru.gb.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.dto.BookRequest;
import ru.gb.model.Book;
import ru.gb.repository.BooksRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Class for test {@link BookService}
 */
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BooksRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    public void addBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(new Book());

        Book book = bookService.addBook(prepareRequest());

        verify(bookRepository).save(any(Book.class));
        assertEquals(book, new Book());
    }

    @Test
    public void getAll() {
        when(bookRepository.findAll()).thenReturn(List.of(prepareBook()));

        List<Book> booksList = bookService.getAll();

        verify(bookRepository).findAll();
        assertEquals(booksList, List.of(prepareBook()));
    }

    @Test
    public void getBookById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(prepareBook()));

        Book book = bookService.getBookById(1L);

        verify(bookRepository).findById(1L);
        assertEquals(book, prepareBook());
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(1L);
        verify(bookRepository).deleteById(1L);
    }

    private BookRequest prepareRequest() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setName("");
        return bookRequest;
    }

    private Book prepareBook() {
        Book book = new Book();
        book.setId(1L);
        book.setName("name");
        return book;
    }
}
