package com.projet.rest_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
@ControllerAdvice
public class CloudVendorExceptionHandler {
    @ExceptionHandler(value = CloudVendorNotFoundException.class)
    public ResponseEntity<Object> handleCloudVendorException
        (CloudVendorNotFoundException cloudVendorNotFoundException) 
        {
            CloudVendorException cloudVendorException = new CloudVendorException(cloudVendorNotFoundException.getMessage(),
                                        cloudVendorNotFoundException.getCause() ,
                                        HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(cloudVendorNotFoundException, HttpStatus.NOT_FOUND);
        }
}
