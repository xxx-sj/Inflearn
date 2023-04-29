package jpaBook.jpaShop.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class CustomExceptionHandler {

//    @ExceptionHandler(IllegalStateException.class)
//    public ResponseEntity<String> handlerException(IllegalStateException e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
//    }
}
