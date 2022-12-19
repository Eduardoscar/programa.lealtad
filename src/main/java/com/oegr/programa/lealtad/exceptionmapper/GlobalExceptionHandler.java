package com.oegr.programa.lealtad.exceptionmapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundExceptionMapper.class)
    public ResponseEntity<ErrorDetails> NotFoundExceptionMapper(NotFoundExceptionMapper exception) {
        String msg = exception.getMessage();
        HttpStatus code = HttpStatus.NOT_FOUND;
        ErrorDetails errorModel = new ErrorDetails(code.value(), msg);
        log.warn("status: {} message: {}", code.value(), msg);
        return new ResponseEntity<ErrorDetails>(errorModel, code);
    }

    @ExceptionHandler(BadRequestExceptionMapper.class)
    public ResponseEntity<ErrorDetails> BadRequestExceptionMapper(BadRequestExceptionMapper exception) {
        String msg = exception.getMessage();
        HttpStatus code = HttpStatus.BAD_REQUEST;
        ErrorDetails errorModel = new ErrorDetails(code.value(), msg);
        log.warn("status: {} message: {}", code.value(), msg);
        return new ResponseEntity<ErrorDetails>(errorModel, code);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception exception) {
        String msg = exception.getMessage();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDetails errorModel = new ErrorDetails(status.value(), msg);
        log.error("status: {} message: {}", status.value(), msg);
        return new ResponseEntity<>(errorModel, status);
    }
}
