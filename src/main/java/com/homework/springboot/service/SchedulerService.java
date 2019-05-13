package com.homework.springboot.service;

import com.homework.springboot.model.User;

import com.homework.springboot.service.impl.WRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SchedulerService {

    private final UserService userService;

    private final EmailService emailService;

   // @Scheduled(cron = CRON)
    @Scheduled(cron="${cronExpression}")
    public void sendMailToUsers() throws WRuntimeException {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        List<User> list = userService.getUsersByBirthday(month, day);
        if (!list.isEmpty()) {
            for (User user : list) {
                try {
                    String message = "Happy Birthday dear " + user.getName() + "!";
                    emailService.send(user.getEmail(), "Happy Birthday!", message);
                    log.info("Email have been sent. User id: {}, Date: {}", user.getId());
                } catch (Exception e) {
                    log.error("Email can't be sent.User's id: {}, Error: {}", user.getId(), e.getMessage());
                    log.error("Email can't be sent", e);
                }
            }
        }
    }

}
