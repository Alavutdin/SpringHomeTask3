package com.example.sem3HomeTask.repository;

import com.example.sem3HomeTask.domains.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private List<User> users = new ArrayList<>();
    /**
     * Метод получения списка пользователей
     * */

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }



}
