package pl.sdacademy.citizens.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimalTest {

    @Test
    public void shouldReadIdFromElementWithIndex0() {
        CsvLine csvLine = mock(CsvLine.class);
        when(csvLine.getElementAt(0)).thenReturn("12");

        Animal animal = new Animal(csvLine);

        assertNotNull(animal);
        assertEquals((Long) 12L, animal.getId());
    }

    @Test
    public void shouldReadNameFromElementWithIndex1() {
        CsvLine csvLine = mock(CsvLine.class);
        when(csvLine.getElementAt(1)).thenReturn("Lambert");

        Animal animal = new Animal(csvLine);

        assertNotNull(animal);
        assertEquals("Lambert", animal.getName());
    }

    @Test
    public void shouldReadGenreFromElementWithIndex2() {
        CsvLine csvLine = mock(CsvLine.class);
        when(csvLine.getElementAt(2)).thenReturn("DOG");

        Animal animal = new Animal(csvLine);

        assertNotNull(animal);
        assertEquals("DOG", animal.getGenre());
    }

}