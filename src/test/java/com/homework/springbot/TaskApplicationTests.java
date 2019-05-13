package com.homework.springbot;

import com.homework.springboot.model.User;
import com.homework.springboot.service.UserService;
import lombok.NoArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@NoArgsConstructor
@DataJpaTest
public class TaskApplicationTests {

    @Autowired
    private UserService service;

    private User user;

    @Before
    public void setUp() {
        user = new User();
                user.setName("Andrew");
                user.setAge(30);
                user.setEmail("akulmm@gmail.com");
                user.setBirthday(LocalDate.of(1989, 12, 18));
        service.saveUser(user);
    }

    @After
    public void drop() {
        service.deleteUser(User.getId());
    }

    @Test
    public void createUserTest() {
        User student = new User();
                user.setName("Gorge");
                user.setAge(40);
                user.setEmail("gorge@gmail.com");
                user.setBirthday(LocalDate.of(1979, 05, 25));
        service.saveUser(student);
        assertTrue(String.valueOf((service.getUsersByBirthday(05,21).contains(user))),true);
    }
}
