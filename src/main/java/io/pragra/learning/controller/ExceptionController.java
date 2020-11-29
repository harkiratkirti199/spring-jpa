package io.pragra.learning.controller;

import io.pragra.learning.domain.ErrorResponse;
import io.pragra.learning.exceptions.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    protected ResponseEntity<Object> bookNotFound(RuntimeException ex, WebRequest request) {
        ErrorResponse response=new ErrorResponse(ex.getMessage(), LocalDateTime.now(), "Not_FOUND");
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
