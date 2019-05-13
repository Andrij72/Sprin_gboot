package com.homework.springboot.service.impl;

import com.homework.springboot.model.User;
import com.homework.springboot.repository.UserRepository;
import com.homework.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService  {

    private  UserRepository repository ;

    @Override
    public void saveUser(User user) {
    }

    @Override
    public List<User> getUsersByBirthday(int month, int day) {
        return repository.findByMatchMonthAndMatchDay(month, day);
    }

    @Override
    public void deleteUser(Long id) {
    }
}
