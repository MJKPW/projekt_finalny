package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IncorrectInputException.class)
    public ResponseEntity<Object> handleIncorrectInputException() {
        return new ResponseEntity<>("Wrong input provided", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<Object> handleInsufficientFundsException() {
        return new ResponseEntity<>("Insufficient funds", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WalletStateNotFoundException.class)
    public ResponseEntity<Object> handleWalletStateNotFoundException() {
        return new ResponseEntity<>("State with given id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransactionLogNotFoundException.class)
    public ResponseEntity<Object> handleTransactionLogNotFoundException() {
        return new ResponseEntity<>("Transaction with given id does not exist", HttpStatus.BAD_REQUEST);
    }
}
