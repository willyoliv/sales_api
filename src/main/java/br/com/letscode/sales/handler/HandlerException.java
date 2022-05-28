package br.com.letscode.sales.handler;

import br.com.letscode.sales.exception.ExceptionDetails;
import br.com.letscode.sales.exception.SaleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SaleNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerSaleNotFoundException(SaleNotFoundException saleNotFoundException) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Not found Exception, Sale(s) not found!")
                .details(saleNotFoundException.getMessage())
                .developerMessage(saleNotFoundException.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }
}
