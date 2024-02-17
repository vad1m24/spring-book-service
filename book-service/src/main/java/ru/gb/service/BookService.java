package ru.gb.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dto.BookRequest;
import ru.gb.model.Book;
import ru.gb.repository.BooksRepository;
//import ru.ru.gb.utils.Timer;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
//@Timer
public class BookService {

    private final BooksRepository bookRepository;

    public Book addBook(BookRequest bookRequest) {
        return bookRepository.save(new Book(bookRequest.getName()));
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }
}
