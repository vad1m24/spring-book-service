//package ru.gb.repository;
//
//import com.github.javafaker.Faker;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//import ru.gb.dto.BookRequest;
//import ru.gb.service.BookService;
//
//@Component
//@RequiredArgsConstructor
//public class StartRepository implements ApplicationRunner {
//
//    private final BookService bookService;
//    private Faker faker;
//
//    @Override
//    public void run(ApplicationArguments args) {
//        this.faker=new Faker();
//        for (int i = 0; i < 15; i++) {
//            bookService.addBook(new BookRequest(faker.book().title()));
//        }
//    }
//}
