package com.churrasco.challenge.exception;

public enum ExceptionEnum {

    ENTITYNOTFOUND("Entity not found"),
    PRODUCTNOTFOUND("Product not found"),
    USERALREADYEXIST("User already exist"),
    USERNAMENOTFOUND("Username not found"),
    INVALIDUSERNAMEORPASSWORD("Invalid Username or Password");

    private String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
