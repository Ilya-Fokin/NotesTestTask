package org.example.exceptions;

public class NotesException extends Exception{
    public NotesException() {
    }

    public NotesException(String message) {
        super(message);
    }

    public NotesException(String message, Throwable cause) {
        super(message, cause);
    }
}
