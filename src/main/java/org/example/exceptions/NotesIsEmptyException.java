package org.example.exceptions;

public class NotesIsEmptyException extends NotesException {
    public NotesIsEmptyException() {
    }

    public NotesIsEmptyException(String message) {
        super(message);
    }

    public NotesIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
