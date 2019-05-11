package com.homework.springboot.service;

import com.homework.springboot.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SchedulerService {
    public static final Logger LOGGER = Logger.getLogger(SchedulerService.class.getName());
    private static final String CRON = "*/10 * * * * *";

    private  UserRepositoryService userService;

    private  EmailService emailService;

    @Scheduled(cron = CRON)
    public void sendMailToUsers() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        List<User> list = userService.getUsersByBirthday(month, day);
        if (!list.isEmpty()) {
            list.forEach(user -> {
                try {
                    String message = "Happy Birthday dear " + user.getName() + "!";
                    emailService.send(user.getEmail(), "Happy Birthday!", message);
                 LOGGER.info("Email have been sent. User id: {}, Date: {}", user.getId(), date);
                } catch (Exception e) {
                   LOGGER.error("Email can't be sent.User's id: {}, Error: {}", user.getId(), e.getMessage());
                   LOGGER.error("Email can't be sent", e);
                }
            });
        }
    }

}
