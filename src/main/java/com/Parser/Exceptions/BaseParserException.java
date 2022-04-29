package com.Parser.Exceptions;

public abstract class BaseParserException extends Exception{
    private String message;

    public BaseParserException(String msg) {
        this.message = msg;
    }

    public String getMessage() { return this.message; }
}
