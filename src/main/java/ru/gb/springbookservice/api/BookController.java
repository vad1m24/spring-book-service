package ru.gb.springbookservice.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbookservice.dto.BookRequest;
import ru.gb.springbookservice.model.Book;
import ru.gb.springbookservice.service.BookService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
@Tag(name = "Книги")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    @Operation(summary = "get all books", description = "Получение списка всех книг")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "get book by id", description = "Получение книги по идентификационному номеру")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    @Operation(summary = "add a new book", description = "Добавление новой книги")
    public Book addBook(@RequestBody BookRequest bookRequest) {
        return bookService.addBook(bookRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete book by id", description = "Удаление книги по идентификационному номеру")
    public void deleteBookById(@PathVariable long id) {
        bookService.deleteBookById(id);
    }
}
