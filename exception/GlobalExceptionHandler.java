package com.fintech.ledger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            InvalidLedgerException.class)

    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public Map<String,String> handleLedger(
            InvalidLedgerException ex){

        return Map.of(
                "error",
                ex.getMessage()
        );
    }

    @ExceptionHandler(
            MethodArgumentNotValidException.class)

    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public Map<String,String> validation(
            MethodArgumentNotValidException ex){

        return Map.of(
                "error",
                "Validation failed"
        );
    }

}
