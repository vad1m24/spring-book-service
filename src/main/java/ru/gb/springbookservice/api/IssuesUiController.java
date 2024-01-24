package ru.gb.springbookservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbookservice.service.BookService;
import ru.gb.springbookservice.service.IssueService;


@Controller
@RequestMapping("/ui")
@RequiredArgsConstructor
public class IssuesUiController {

    private final IssueService issueService;

    @GetMapping("/issues")
    public String library( Model model) {
        model.addAttribute("issues", issueService.getAll());
        model.addAttribute("books", issueService.getBookRepository());
        model.addAttribute("readers", issueService.getReaderRepository());
        return "issue";
    }


}
