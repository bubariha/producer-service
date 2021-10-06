package com.microservice.producerservie;

import com.microservice.producerservie.model.PublishResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException argumentNotValidException, HttpHeaders httpHeaders,
                                                                  HttpStatus httpStatus, WebRequest webRequest) {
        Map<String, String> errors = argumentNotValidException.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        PublishResponse publishResponse = new PublishResponse("failed", errors.toString());
        publishResponse.setErrorType(argumentNotValidException.getClass().getSimpleName());
        return new ResponseEntity<>(publishResponse, HttpStatus.BAD_REQUEST);
    }
}
