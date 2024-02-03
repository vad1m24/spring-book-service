package ru.gb.springbookservice.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbookservice.service.ReaderService;


@Controller
@RequestMapping("/ui")
@Tag(name = "UI")
@RequiredArgsConstructor
public class ReadersUiController {

    private final ReaderService readerService;

    @GetMapping("/readers")
    @Operation(summary = "get all readers", description = "Получение таблицы с перечнем всех читателей")
    public String library( Model model) {
        model.addAttribute("readers", readerService.getAll());
        return "reader";
    }

}
