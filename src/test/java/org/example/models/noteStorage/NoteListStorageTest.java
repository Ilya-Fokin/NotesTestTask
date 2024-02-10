package org.example.models.noteStorage;

import org.example.exceptions.NotesException;
import org.example.models.Note;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteListStorageTest {
    NoteListStorage noteListStorage;

    @BeforeEach
    public void setUp() {
        noteListStorage = new NoteListStorage();
    }

    @Test
    void add() throws NotesException {
        Note note = new Note("Продукты", "Молоко, чай, фрукты");

        noteListStorage.add(note);

        assertEquals(note, noteListStorage.getNote(0));
    }

    @Test
    void testEditNotValidIndex() {
        noteListStorage.add(new Note("Продукты", "Молоко, чай, фрукты"));

        assertThrows(NotesException.class, () -> noteListStorage.edit(7, "Updated Text"));
    }
    @Test

    void testEditValidIndex() throws NotesException {
        noteListStorage.add(new Note("Продукты", "Молоко, чай, фрукты"));

        noteListStorage.edit(0, "Лимонад, соль");

        assertEquals("Лимонад, соль", noteListStorage.getNote(0).getText());
    }

    @Test
    void remove() throws NotesException {
        Note note = new Note("Продукты", "Молоко, чай, фрукты");
        Note note2 = new Note("Показания", "Кухня (холод) - 1254, кухня (горячая) - 751");
        noteListStorage.add(note);
        noteListStorage.add(note2);

        noteListStorage.remove(1);

        assertFalse(noteListStorage.getAll().contains(note2));
    }
}