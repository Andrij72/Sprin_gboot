package com.homework.springboot.service;

import com.homework.springboot.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void deleteUser(Long id);

    List<User> getUsersByBirthday(int month, int day);

    void deleteUser(Integer id);
}
