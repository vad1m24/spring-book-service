package ru.gb.springbookservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.gb.springbookservice.dto.BookRequest;
import ru.gb.springbookservice.dto.UserRequest;
import ru.gb.springbookservice.model.Role;
import ru.gb.springbookservice.service.BookService;
import ru.gb.springbookservice.service.RoleService;
import ru.gb.springbookservice.service.UserService;


@Component
@RequiredArgsConstructor
public class ContextualRepository implements ApplicationRunner {

    private final BookService bookService;
    private final UserService userService;
    private final RoleService roleService;


    @Override
    public void run(ApplicationArguments args) {
        bookService.addBook(new BookRequest("война и мир"));
        bookService.addBook(new BookRequest("метрвые души"));
        bookService.addBook(new BookRequest("чистый код"));

        userService.addUser(new UserRequest("admin", "admin"));
        userService.addUser(new UserRequest("user", "user"));
        userService.addUser(new UserRequest("reader", "reader"));

        roleService.addRole(new Role("admin"));
        roleService.addRole(new Role("user"));
        roleService.addRole(new Role("reader"));

        userService.addRoleToUser(1L, 1L);
        userService.addRoleToUser(2L, 2L);
        userService.addRoleToUser(3L, 3L);
    }
}