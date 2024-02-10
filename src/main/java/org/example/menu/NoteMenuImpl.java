package org.example.menu;

import lombok.AllArgsConstructor;
import org.example.exceptions.NotesException;
import org.example.models.Note;
import org.example.models.noteStorage.NoteStorage;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

@AllArgsConstructor
public class NoteMenuImpl implements NoteMenu {
    private Scanner in;
    private NoteStorage noteStorage;

    @Override
    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.print(
                    """
                            Добро пожаловать в приложение "Заметки"!
                            1. Добавить заметку
                            2. Просмотреть заметки
                            3. Редактировать заметку
                            4. Удалить заметку
                            5. Открыть заметку
                            6. Выход
                            Выберите действие (введите номер):
                            """
            );
            int c = in.nextInt();
            switch (c) {
                case 1:
                    addNote();
                    break;
                case 2:
                    showNotes();
                    break;
                case 3:
                    editNote();
                    break;
                case 4:
                    removeNote();
                    break;
                case 5:
                    getNote();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Такого пункта в меню нет");
            }
        }
    }

    private void addNote() {
        Note note = new Note();
        boolean valid = false;
        while (!valid) {
            in.nextLine();
            System.out.print("Введите заголовок заметки: ");
            String title = in.nextLine();
            if (title.isEmpty()) {
                System.out.println("""
                        __________________________________
                        Заголовок не может быть пустым
                        __________________________________
                        """);
            } else {
                note.setTitle(title);
                valid = true;
            }
        }
        String text = inputText();
        note.setText(text);
        noteStorage.add(note);
        System.out.println("Заметка " + note.getTitle() + " добавлена");
    }

    private String inputText() {
        System.out.println("Введите новый текст заметки (для завершения введите \"end\"):");
        StringBuilder text = new StringBuilder();
        String nextLine;
        while (!(nextLine = in.nextLine()).equals("end")) {
            text.append(nextLine).append("\n");
        }
        return text.toString();
    }

    private void showNotes() {
        List<Note> notes = noteStorage.getAll();
        if (notes.isEmpty()) {
            System.out.println("""
                    ____________________________
                    Заметок пока нет
                    ____________________________
                    """);
        } else {
            System.out.println("_____________________________________");
            IntStream.range(0, notes.size())
                    .forEach(i -> System.out.println((i + 1) + ": "
                            + notes.get(i).getTitle() + " (" + notes.get(i).getDate() + ")"));
            System.out.println("_____________________________________");
        }
    }

    private void editNote() {
        System.out.println("Введите номер заметки для редактирования: ");
        int index = in.nextInt();
        String text = inputText();
        try {
            noteStorage.edit(--index, text);
            System.out.println("""
                    ___________________________
                    Заметка изменена
                    ___________________________
                    """);
        } catch (NotesException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void removeNote() {
        System.out.print("Введите номер заметки для удаления:");
        int index = in.nextInt();
        try {
            Note note = noteStorage.remove(--index);
            System.out.println("_____________________________________");
            System.out.println("Заметка '" + note.getTitle() + "' удалена");
            System.out.println("_____________________________________");
        } catch (NotesException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void getNote() {
        System.out.print("Введите номер заметки: ");
        int index = in.nextInt();
        try {
            Note note = noteStorage.getNote(--index);
            if (note != null) {
                System.out.println("_____________________________________");
                System.out.println("Заголовок: " + note.getTitle() + "\n"
                        + "Дата: " + note.getDate() + "\n"
                        + "Содержание:\n" + note.getText());
                System.out.println("_____________________________________");
            } else System.out.println("""
                __________________________
                Такой заметки нет
                __________________________
                """);
        } catch (NotesException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
