package com.anataarisa.pimtool.controller;

import com.anataarisa.pimtool.model.exception.EntitySearchNotFoundException;
import com.anataarisa.pimtool.model.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApplicationExceptionController {
    @ExceptionHandler(EntitySearchNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage entityNotFoundException(EntitySearchNotFoundException entitySearchNotFoundException, WebRequest request) {
        return new ErrorMessage(HttpStatus.NOT_FOUND, entitySearchNotFoundException.getMessage(),entitySearchNotFoundException.getCause().toString());
    }
}