package com.example.monstudy.exception;

public class ClientBadRequestRuntimeException extends RuntimeException {
    public ClientBadRequestRuntimeException(ExceptionMessage message) {
        super(message.getMessage());
    }
}
