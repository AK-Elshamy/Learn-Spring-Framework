package com.elshamy.spring.exception;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException exception
    ){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage()));

        ErrorResponse response = toErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "check data input",
                errors
                );
        return ResponseEntity.badRequest().body(response);
    }

    private ErrorResponse toErrorResponse(int status, String message, Map<String, String> errors){
        return new ErrorResponse(LocalDateTime.now(),
                status,
                message,
                errors
                );
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException exception){

        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        ErrorResponse response = toErrorResponse(HttpStatus.NOT_FOUND.value(),
                "Add a valid id",
                errors);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> handleGeneralException(Exception exception){
        ErrorResponse response = toErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal server error",
                new HashMap<>()
                );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
