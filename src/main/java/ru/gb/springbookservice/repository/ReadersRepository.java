package ru.gb.springbookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springbookservice.model.Reader;

public interface ReadersRepository extends JpaRepository<Reader,Long> {
}
