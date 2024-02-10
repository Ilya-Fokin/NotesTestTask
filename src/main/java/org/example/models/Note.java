package org.example.models;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @NonNull
    private String title;
    @NonNull
    private String text;
    private LocalDate date;

    {
        this.date = LocalDate.now();
    }
}
