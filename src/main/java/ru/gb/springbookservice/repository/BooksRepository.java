package ru.gb.springbookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.springbookservice.model.Book;


public interface BooksRepository extends JpaRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {
}
