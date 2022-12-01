package com.example.mdbspring.listener;

import com.example.mdbspring.model.Person;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class PersonModelListener extends AbstractMongoEventListener {

    /*@Override
    public void onBeforeConvert(BeforeConvertEvent event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Person.SEQUENCE_NAME));
        }
    }*/
}
