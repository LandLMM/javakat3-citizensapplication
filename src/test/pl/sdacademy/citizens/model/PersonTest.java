package pl.sdacademy.citizens.model;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonTest {

    @Test
    public void shouldCalculateAge() throws ParseException {
        Person person = Person.builder().birthDate("1990-11-29").build();

        assertNotNull(person);
        assertEquals((Integer) 27, person.getAge());
    }

    @Test
    public void shouldUseBuilderForPersonCreation() throws ParseException {
        Long id = 123L;
        String name = "SampleName";
        String lastName = "SampleLastName";
        String sex = "M";
        String birthDate = "1988-04-09";

        Person person = Person.builder().id(id).name(name).lastName(lastName).sex(sex).birthDate(birthDate).build();

        assertNotNull(person);
        assertEquals(id, person.getId());
        assertEquals(name, person.getName());
        assertEquals(lastName, person.getLastName());
        assertEquals(sex, person.getSex());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse(birthDate), person.getBirthDate());
    }

}