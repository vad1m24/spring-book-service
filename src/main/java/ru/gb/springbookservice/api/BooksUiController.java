package ru.gb.springbookservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbookservice.service.BookService;


@Controller
@RequestMapping("/ui")
@RequiredArgsConstructor
public class BooksUiController {

    private final BookService bookService;

    @GetMapping("/books")
    public String library( Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book";
    }

//    @GetMapping("/home")
//    public String home(@RequestParam(required = false) String name, Model model){
//        if (name!=null){
//            model.addAttribute("name", name);
//        } else {
//            model.addAttribute("name", "world");
//        }
//        return "home";
//    }

}
