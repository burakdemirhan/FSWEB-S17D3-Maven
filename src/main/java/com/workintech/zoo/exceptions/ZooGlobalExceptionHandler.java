package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ZooGlobalExceptionHandler {
  @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleZooException(ZooException zooException){
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(zooException.getMessage(), zooException.getHttpStatus().value(), System.currentTimeMillis());
        return new ResponseEntity<>(zooErrorResponse, zooException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleGenericException(Exception exception){
      ZooErrorResponse zooErrorResponse = new ZooErrorResponse("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis());
      return new ResponseEntity<>(zooErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
