package org.example;

import org.example.menu.NoteMenu;
import org.example.menu.NoteMenuImpl;
import org.example.models.noteStorage.NoteListStorage;
import org.example.models.noteStorage.NoteStorage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NoteStorage noteStorage = new NoteListStorage();
        Scanner in = new Scanner(System.in);

        NoteMenu noteMenu = new NoteMenuImpl(in, noteStorage);
        noteMenu.showMenu();
    }
}