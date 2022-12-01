package com.example.mdbspring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "person")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class Person {

    @Transient
    public static final String SEQUENCE_NAME = "person_sequence";

    @Id
    private long personId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String mobile;
    private List<String> hobbies;
    private List<Address> addresses;

    @Override
    public String toString() {
        return super.toString();
    }
}
