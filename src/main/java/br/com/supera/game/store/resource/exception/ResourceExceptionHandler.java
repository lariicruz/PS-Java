package br.com.supera.game.store.resource.exception;


import br.com.supera.game.store.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(),System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);

    }


}
