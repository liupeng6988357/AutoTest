package com.auto.exception;

public class MyError extends Exception {

    public MyError(String message) {
        super(message);
    }

    public MyError(String message, Throwable cause) {
        super(message, cause);
    }
}
