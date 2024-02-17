package ru.gb.service;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.api.Book;

public interface BookController {

    @RequestMapping("book/{id}")
    Book find();
}
