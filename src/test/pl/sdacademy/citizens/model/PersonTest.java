package pl.sdacademy.citizens.model;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonTest {

    @Test
    public void shouldCalculateAge() throws ParseException {
        CsvLine csvLine = mock(CsvLine.class);
        when(csvLine.getElementAt(0)).thenReturn("0");
        when(csvLine.getElementAt(4)).thenReturn("1990-11-29");

        Person person = new Person(csvLine);

        assertNotNull(person);
        assertEquals((Integer) 27, person.getAge());
    }

}