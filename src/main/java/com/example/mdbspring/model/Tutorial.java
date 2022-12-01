package com.example.mdbspring.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
@Document(collection = "tutorial")
public class Tutorial {

    @Id
    private String id;

    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private boolean published;

    @Override
    public String toString() {
        return "Tutorial{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                '}';
    }
}
