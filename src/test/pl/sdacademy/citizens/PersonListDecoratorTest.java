package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Person;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonListDecoratorTest {

    public void shouldUsePersonListToInitialize() {
        List<Person> personList = new ArrayList<>();

        PersonListDecorator decorator = new PersonListDecorator(personList);

        assertNotNull(decorator);
    }

}