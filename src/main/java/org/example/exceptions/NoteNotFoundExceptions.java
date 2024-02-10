package org.example.exceptions;

public class NoteNotFoundExceptions extends NotesException {
    public NoteNotFoundExceptions() {
    }

    public NoteNotFoundExceptions(String message) {
        super(message);
    }

    public NoteNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
