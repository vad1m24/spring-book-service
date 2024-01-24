package ru.gb.springbookservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbookservice.service.ReaderService;


@Controller
@RequestMapping("/ui")
@RequiredArgsConstructor
public class ReadersUiController {

    private final ReaderService readerService;

    @GetMapping("/readers")
    public String library( Model model) {
        model.addAttribute("readers", readerService.getAll());
        return "reader";
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
