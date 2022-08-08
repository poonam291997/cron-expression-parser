package org.example.exception;

public class UnsupportedCharacterException extends Exception{
    public UnsupportedCharacterException(String message) {
        super(String.format("Characters in expression are not supported by %s parser", message));
    }
}