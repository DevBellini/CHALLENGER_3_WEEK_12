package br.guilherme.bellini.msemployees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
