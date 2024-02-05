package ru.gb.springbookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.springbookservice.model.Role;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {

    List<Role> findRolesByUsersId(Long userId);
}
