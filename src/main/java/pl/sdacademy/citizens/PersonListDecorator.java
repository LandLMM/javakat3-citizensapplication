package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Person;

import java.util.ArrayList;
import java.util.Collection;

public class PersonListDecorator extends ArrayList<Person> {

    public PersonListDecorator(Collection<? extends Person> c) {
        super(c);
    }
}
