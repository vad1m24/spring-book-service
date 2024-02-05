package ru.gb.springbookservice.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbookservice.model.Role;
import ru.gb.springbookservice.repository.RolesRepository;

@Data
@Service
@RequiredArgsConstructor
public class RoleService {

    private final RolesRepository rolesRepository;

    public Role addRole (Role role){
        return rolesRepository.save(role);
    }
}
