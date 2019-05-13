package com.homework.springboot.service.impl;
import com.homework.springboot.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    public EmailServiceImpl() {
        emailSender = null;
    }

    @Override
    public void send(String to, String subject, String text) throws WRuntimeException {
        MimeMessage message = this.emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            this.emailSender.send(message);
            log.info("Ok, normal completion");
        } catch (WRuntimeException e) {
            log.error("Catch error" + e);
        }
    }
}
