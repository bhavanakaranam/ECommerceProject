package com.scaler.ecomproductservice.controller.controlleradvice;

import com.scaler.ecomproductservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice
{
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(Exception ex)
    {
        String exceptionMessage = ex.getMessage() + "Code "+ HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.ok(exceptionMessage);
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(Exception ex)
    {
        String exceptionMessage = ex.getMessage() + "Code "+ HttpStatus.NOT_FOUND;
        return ResponseEntity.ok(exceptionMessage);
    }

}
