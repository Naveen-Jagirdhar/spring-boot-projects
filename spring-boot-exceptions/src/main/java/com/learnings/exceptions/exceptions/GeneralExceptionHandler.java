package com.learnings.exceptions.exceptions;

import com.learnings.exceptions.utils.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoDataAvailableException.class})
    public ResponseEntity<Object> NoDataAvailableExceptionHandler(NoDataAvailableException ex, WebRequest webRequest) {
        List<String> errorDetails = new ArrayList<>();
        errorDetails.add(ex.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse(errorDetails, new Date());
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorDetails = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            errorDetails.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse(errorDetails, new Date());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}