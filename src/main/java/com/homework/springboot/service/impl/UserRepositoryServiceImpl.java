package com.homework.springboot.service.impl;

import com.homework.springboot.model.User;
import com.homework.springboot.repository.UserRepository;
import com.homework.springboot.service.UserRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRepositoryServiceImpl implements UserRepositoryService {

    private final UserRepository repository = null;

    @Override
    public List<User> getUsersByBirthday(int month, int day) {
        return repository.findByMatchMonthAndMatchDay(month, day);
    }

}
