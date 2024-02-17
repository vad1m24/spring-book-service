package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.gb.api.Book;



@Service
@RequiredArgsConstructor
public class BookProvider {

    private final WebClient webClient;


    public Book getBookById(long bookId) {
        return webClient.get().uri("http://localhost:8282/book/" + bookId).retrieve().bodyToMono(Book.class).block();
    }
}
