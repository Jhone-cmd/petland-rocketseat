package com.jhonecmd.petland.exceptions;

public class RegisterAlreadyExists extends RuntimeException {
    public RegisterAlreadyExists(String message) {
        super(message);
    }
}
