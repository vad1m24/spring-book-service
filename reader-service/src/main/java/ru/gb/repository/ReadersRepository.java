package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Reader;

public interface ReadersRepository extends JpaRepository<Reader,Long> {
}
