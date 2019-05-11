package com.homework.springboot.service;

import com.homework.springboot.model.User;

import java.util.List;

public interface UserRepositoryService {

    List<User> getUsersByBirthday(int month, int day);
}
