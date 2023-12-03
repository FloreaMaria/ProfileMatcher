package com.example.profilematcher.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ EmptyFieldException.class, NoUserProfileFoundException.class})
    public ResponseEntity<?> handleNotFoundException(RuntimeException e) {
        Map<String, String> responseParameters = new HashMap<>();
        responseParameters.put("Reason: ", e.getMessage());
        responseParameters.put("DateTime: ", LocalDateTime.now().toString());
        return ResponseEntity.badRequest().body(responseParameters);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleHibernateObjectValidation(MethodArgumentNotValidException exception) {
        Map<String, Object> responseParameters = new HashMap<>();

        List<String> errors = exception.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        responseParameters.put("Reason: ", errors);
        responseParameters.put("DateTime: ", LocalDateTime.now().toString());
        return ResponseEntity.badRequest().body(responseParameters);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleHibernateParametersValidation(ConstraintViolationException exception) {
        Map<String, Object> responseParameters = new HashMap<>();
        List<String> errors = Collections.singletonList(exception.getMessage());
        responseParameters.put("Reason: ", errors);
        responseParameters.put("DateTime: ", LocalDateTime.now().toString());
        return ResponseEntity.badRequest().body(responseParameters);
    }
}