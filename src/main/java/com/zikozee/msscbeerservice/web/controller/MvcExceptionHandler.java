package com.zikozee.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ezekiel Eromosei
 * @created: 14 May 2022
 */

@RestControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<?>> validationExceptionHandler(ConstraintViolationException ex){
        List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach(error -> errorList.add(error.toString()));

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
