package com.autourducode.democrud.configs.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 *
 * @author autourducode
 */
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<MyExceptionPayLoad> handlerActorException(final MyException ex){
        return respondWithExceptionPayload(ex.getPayLoad());
    }

    private ResponseEntity<MyExceptionPayLoad> respondWithExceptionPayload(final MyExceptionPayLoad payload) {
        return ResponseEntity.status(payload.getHttpCode()).body(payload);
    }
}
