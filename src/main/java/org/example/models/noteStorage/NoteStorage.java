package org.example.models.noteStorage;

import org.example.exceptions.NotesException;
import org.example.models.Note;

import java.util.List;

public abstract class NoteStorage {
    abstract public void add(Note note);

    abstract public void edit(int index, String text) throws NotesException;

    abstract public Note remove(int index) throws NotesException;

    abstract public List<Note> getAll();

    abstract public Note getNote(int index) throws NotesException;
}
