package com.oegr.programa.lealtad.exceptionmapper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthenticationExceptionMapper extends RuntimeException {
    public AuthenticationExceptionMapper(String message) {
        super(message);
    }

}
