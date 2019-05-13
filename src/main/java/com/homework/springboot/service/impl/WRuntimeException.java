package com.homework.springboot.service.impl;

public class WRuntimeException extends Throwable {
    private int detail;
    public WRuntimeException(int a) {
        detail = a;
    }
    public String toString() {
        return "MyException!" + detail+"]";
    }
}
