package com.coodecool.plaza.api;

public class ProductAlreadyExistsException extends Exception {

    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
