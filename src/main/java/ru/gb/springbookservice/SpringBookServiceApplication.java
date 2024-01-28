package ru.gb.springbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.springbookservice.dto.BookRequest;
import ru.gb.springbookservice.service.BookService;

@SpringBootApplication
public class SpringBookServiceApplication {

    private BookService bookService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBookServiceApplication.class, args);
        BookService bean = context.getBean(BookService.class);
        bean.addBook(new BookRequest("война и мир"));
        bean.addBook(new BookRequest("метрвые души"));
        bean.addBook(new BookRequest("чистый код"));
    }

}
