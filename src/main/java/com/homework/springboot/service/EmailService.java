package com.homework.springboot.service;

import com.homework.springboot.service.impl.WRuntimeException;

public interface EmailService {
    void send(String to, String title, String body) throws WRuntimeException;
}
