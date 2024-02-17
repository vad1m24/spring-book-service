package ru.gb.service;

import org.springframework.web.bind.annotation.RestController;
import ru.gb.api.Book;

@RestController
public class EurekaClientApp implements BookController {

    @Override
    public Book find() {
        return null;
    }
}