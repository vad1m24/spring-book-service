package ru.gb.springbookservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

    private String login;

    private String password;

    public UserRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
