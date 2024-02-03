package ru.gb.springbookservice.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbookservice.service.BookService;
import ru.gb.springbookservice.service.IssueService;


@Controller
@RequestMapping("/ui")
@Tag(name = "UI")
@RequiredArgsConstructor
public class IssuesUiController {

    private final IssueService issueService;

    @GetMapping("/issues")
    @Operation(summary = "get all issues", description = "Получение таблицы с перечнем всех выдач книг читателям")
    public String library( Model model) {
        model.addAttribute("issues", issueService.getAll());
        model.addAttribute("books", issueService.getBookRepository());
        model.addAttribute("readers", issueService.getReaderRepository());
        return "issue";
    }


}
