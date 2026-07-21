package com.jhonecmd.petland.exceptions;

public class ProductAndServiceNameAlreadyExists extends RuntimeException {
    public ProductAndServiceNameAlreadyExists(String message) {
        super(message);
    }
}
