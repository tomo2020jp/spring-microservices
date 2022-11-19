package com.tomo.springmicroservice.springmicroservice.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusDays(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusDays(25)));
        users.add(new User(3, "Jim", LocalDate.now().minusDays(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }
}
