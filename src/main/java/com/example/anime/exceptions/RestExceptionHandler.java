package com.example.anime.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoSuchAnimeException.class)
    protected String handleAnimeNotFound(
            RuntimeException ex, WebRequest request) {
        return "Anime not found";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = InvalidStatusException.class)
    protected String handleInvalidStatus(
            RuntimeException ex, WebRequest request) {
        return "Incorrect status";
    }


}
