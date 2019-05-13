package com.homework.springboot.service.impl;

public class WRuntimeException extends Throwable {
    public WRuntimeException(Exception e) {
        e.printStackTrace();
        System.out.println("Wake up the user can not send");
    }
}
