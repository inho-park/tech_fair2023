package com.icc.daelimbada.user.exception;

public class NoUserException extends RuntimeException {
    final private int CODE = 4;

    public NoUserException() {super();}
    public NoUserException(String error) {
        super(error);
    }

    public int getCODE() {
        return CODE;
    }
}
