package org.example.exception;
public class OutOfRangeException extends Exception{
    public OutOfRangeException(String message) {
        super(String.format("Number in expression is out of range for %s parser", message));
    }
}
