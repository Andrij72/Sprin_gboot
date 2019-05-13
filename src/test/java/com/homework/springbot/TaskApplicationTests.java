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

    @Before
    public void setUp() {
       User u = new User();
                u.setName("Andrew");
                u.setAge(30);
                u.setEmail("akulmm@gmail.com");
                u.setBirthday(LocalDate.of(1989, 12, 18));
        service.saveUser(u);
    }

    @After
    public void drop() {
        service.deleteUser(User.getId());
    }

    @Test
    public void createUserTest() {
        User u = new User();
                u.setName("Gorge");
                u.setAge(40);
                u.setEmail("gorge@gmail.com");
                u.setBirthday(LocalDate.of(1979, 05, 25));
        service.saveUser(student);
        assertTrue(String.valueOf((service.getUsersByBirthday(05,21).contains(u))),true);
    }
}
