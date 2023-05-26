package com.Kplus1.appuntesapi.exception;

import com.Kplus1.appuntesapi.utils.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ResponseEntityExceptionHandler.class);


    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<StandardResponse> handleDataNotFound(HttpServletRequest request, DataNotFoundException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }


}
