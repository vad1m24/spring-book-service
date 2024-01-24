package ru.gb.springbookservice.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springbookservice.dto.BookRequest;
import ru.gb.springbookservice.model.Book;
import ru.gb.springbookservice.repository.BookRepository;

import java.util.List;

@Data
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public Book getBookById(long id) {
        return bookRepository.getBookById(id);
    }

    public Book addBook(BookRequest bookRequest) {
        return bookRepository.addBook(new Book(bookRequest.getName()));
    }

    public void deleteBookById(long id) {
        bookRepository.deleteBookById(id);
    }
}
