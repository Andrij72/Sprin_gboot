package com.homework.springboot.service;

public interface EmailService {
    void send(String to, String title, String body);
}
