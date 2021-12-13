package com.demo.calculator.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long id) {
        super("Account id not found : " + id);
    }

}