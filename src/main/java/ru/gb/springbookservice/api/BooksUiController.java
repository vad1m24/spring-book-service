package ru.gb.springbookservice.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbookservice.service.BookService;


@Controller
@RequestMapping("/ui")
@Tag(name = "UI")
@RequiredArgsConstructor
public class BooksUiController {

    private final BookService bookService;

    @GetMapping("/books")
    @Operation(summary = "get all books", description = "Получение таблицы с перечнем всех книг")
    public String library( Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book";
    }

}
