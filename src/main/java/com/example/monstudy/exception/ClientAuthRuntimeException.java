package com.example.monstudy.exception;

public class ClientAuthRuntimeException extends RuntimeException {
    public ClientAuthRuntimeException(ExceptionMessage message) {
        super(message.getMessage());
    }
}
