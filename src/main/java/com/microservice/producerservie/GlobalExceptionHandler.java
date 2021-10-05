package com.microservice.producerservie;

import com.microservice.producerservie.model.PublishResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException argumentNotValidException, HttpHeaders httpHeaders,
                                                                  HttpStatus httpStatus, WebRequest webRequest) {
        argumentNotValidException.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        PublishResponse publishResponse = new PublishResponse("failed", "Invalid fields");
        publishResponse.setErrorType(argumentNotValidException.getClass().getSimpleName());
        return new ResponseEntity<>(publishResponse, HttpStatus.BAD_REQUEST);
    }
}
