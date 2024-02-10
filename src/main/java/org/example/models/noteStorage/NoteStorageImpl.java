package org.example.models.noteStorage;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.exceptions.NoteNotFoundExceptions;
import org.example.models.Note;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class NoteStorageImpl implements NoteStorage{
    private List<Note> noteList;

    @Override
    public void add(Note note) {
        noteList.add(note);
    }

    @Override
    public void edit(Note oldNote, Note newNote) throws NoteNotFoundExceptions {
        int index = noteList.indexOf(oldNote);
        if (index != -1) {
            noteList.set(index, newNote);
        } else {
            throw new NoteNotFoundExceptions("Вы пытаетесь изменить несуществующую заметку");
        }
    }

    @Override
    public void remove(Note note) throws NoteNotFoundExceptions {
        if (noteList.contains(note)) {
            noteList.remove(note);
        } else {
            throw new NoteNotFoundExceptions("Вы пытаетесь удалить несуществующую заметку");
        }
    }

    @Override
    public List<Note> showAll() {
        return noteList;
    }
}
