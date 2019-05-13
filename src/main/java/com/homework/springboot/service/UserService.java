package com.homework.springboot.service;

import com.homework.springboot.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> getUsersByBirthday(int month, int day);

    void deleteUser(Long id);
}
