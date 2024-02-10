package org.example.models.noteStorage;

import org.example.exceptions.NoteNotFoundExceptions;
import org.example.models.Note;

import java.util.List;

public interface NoteStorage {
    void add(Note note);

    void edit(Note oldNote, Note newNote) throws NoteNotFoundExceptions;

    void remove(Note note) throws NoteNotFoundExceptions;

    List<Note> showAll();
}
