package com.example.monstudy.web;

import com.example.monstudy.exception.ClientAuthRuntimeException;
import com.example.monstudy.exception.ClientNoContentRuntimeException;
import com.example.monstudy.web.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.monstudy.web")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ClientNoContentRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResponse handleClientNoContentRuntimeException(RuntimeException e) {
        return CommonResponse.builder().message(e.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    }

    @ExceptionHandler(value = ClientAuthRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResponse handleClientAuthRuntimeException(RuntimeException e) {
        return CommonResponse.builder().message(e.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    }
}
