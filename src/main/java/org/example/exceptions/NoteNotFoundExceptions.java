package org.example.exceptions;

public class NoteNotFoundExceptions extends Exception {
    public NoteNotFoundExceptions() {
    }

    public NoteNotFoundExceptions(String message) {
        super(message);
    }

    public NoteNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteNotFoundExceptions(Throwable cause) {
        super(cause);
    }
}
