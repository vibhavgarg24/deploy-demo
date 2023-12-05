package com.example.deploy.controller;

import com.example.deploy.exception.DuplicateException;
import com.example.deploy.exception.EmptyException;
import com.example.deploy.exception.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;


@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<String> handleDuplicateInput(DuplicateException duplicateException) {

        return new ResponseEntity<String>("Duplicate input", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyException emptyException) {

        return new ResponseEntity<String>("Empty input", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleInvalidInput(InvalidInputException invalidInputException) {

        return new ResponseEntity<String>("Invalid input", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {

        return new ResponseEntity<String>("No such element exception", HttpStatus.NOT_FOUND);
    }
}
