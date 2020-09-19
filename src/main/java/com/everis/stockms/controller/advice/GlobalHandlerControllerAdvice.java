package com.everis.stockms.controller.advice;

import com.everis.stockms.exception.BusinessException;
import com.everis.stockms.exception.ResourceNotFoundException;
import com.everis.stockms.util.ErrorDetailDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalHandlerControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException exception){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDetailDto> businessException(BusinessException exception){
        return new ResponseEntity<>(new ErrorDetailDto(exception.getMessage(),exception.getDateTime()),HttpStatus.OK);
    }

}
