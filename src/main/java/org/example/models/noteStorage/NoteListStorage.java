package org.example.models.noteStorage;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.exceptions.NoteNotFoundExceptions;
import org.example.exceptions.NotesException;
import org.example.exceptions.NotesIsEmptyException;
import org.example.models.Note;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class NoteListStorage extends NoteStorage {
    private List<Note> noteList = new ArrayList<>();

    @Override
    public void add(Note note) {
        noteList.add(note);
    }

    @Override
    public void edit(int index, String text) throws NotesException {
        if (index >= noteList.size()) {
            throw new NoteNotFoundExceptions("""
                    ______________________________________________
                    Вы пытаетесь изменить несуществующую заметку
                    ______________________________________________
                    """);
        }
        Note note = noteList.get(index);
        if (note != null) {
            note.setText(text);
            noteList.set(index, note);
        } else {
            throw new NoteNotFoundExceptions("""
                    ______________________________________________
                    Вы пытаетесь изменить несуществующую заметку
                    ______________________________________________
                    """);
        }
    }

    @Override
    public Note remove(int index) throws NotesException {
        if (noteList.isEmpty()) {
            throw new NotesIsEmptyException("""
                    ______________________________________________
                    Список заметок пуст
                    ______________________________________________
                    """);
        }
        if (index >= noteList.size()) {
            throw new NoteNotFoundExceptions("""
                    ______________________________________________
                    Вы пытаетесь удалить несуществующую заметку
                    ______________________________________________
                    """);
        }
        Note note = noteList.get(index);
        if (note != null) {
            noteList.remove(index);
            return note;
        } else {
            throw new NoteNotFoundExceptions("""
                    ______________________________________________
                    Вы пытаетесь удалить несуществующую заметку
                    ______________________________________________
                    """);
        }
    }

    @Override
    public List<Note> getAll() {
        return noteList;
    }

    @Override
    public Note getNote(int index) throws NotesException {
        if (noteList.isEmpty()) {
            throw new NotesIsEmptyException("""
                    ________________________________
                    Список заметок пуст
                    ________________________________
                    """);
        }
        if (index >= noteList.size()) {
            throw new NoteNotFoundExceptions("""
                    ______________________________________________
                    Вы пытаетесь получить несуществующую заметку
                    ______________________________________________
                    """);
        }
        return noteList.get(index);
    }
}
