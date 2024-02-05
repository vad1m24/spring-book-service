package ru.gb.springbookservice.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbookservice.dto.UserRequest;
import ru.gb.springbookservice.model.Role;
import ru.gb.springbookservice.model.User;
import ru.gb.springbookservice.repository.RolesRepository;
import ru.gb.springbookservice.repository.UserRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Data
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;

    public User addUser(UserRequest userRequest) {
        return userRepository.save(new User(userRequest.getLogin(), userRequest.getPassword()));
    }

    public Optional<User> getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void addRoleToUser(Long userId, Long roleId) {
        Role role = rolesRepository.findById(roleId).orElseThrow(
                () -> new NoSuchElementException("Роль не найдена!"));
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NoSuchElementException("Пользователь не найден!"));
        user.addRole(role);
        userRepository.save(user);
    }
}
