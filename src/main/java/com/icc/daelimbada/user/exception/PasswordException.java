package com.icc.daelimbada.user.exception;

public class PasswordException extends RuntimeException{
    final private int CODE = 5;

    public PasswordException(String error) {
        super(error);
    }
    public int getCODE() {
        return CODE;
    }
}
