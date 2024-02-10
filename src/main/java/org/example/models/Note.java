package org.example.models;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class Note {
    @NonNull
    private String title;
    @NonNull
    private String text;
    @NonNull
    private LocalDate date;

    {
        this.date = LocalDate.now();
    }

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
