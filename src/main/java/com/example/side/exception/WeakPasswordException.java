package com.example.side.exception;

public class WeakPasswordException extends RuntimeException {
    public WeakPasswordException(String msg) {
        super(msg);
    }
}
