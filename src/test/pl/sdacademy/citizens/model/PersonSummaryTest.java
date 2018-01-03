package pl.sdacademy.citizens.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonSummaryTest {

    @Test
    public void shouldProvideIdField() {
        Person person = mock(Person.class);
        when(person.getId()).thenReturn(123L);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Long) 123L, personSummary.getId());
    }

    @Test
    public void shouldProvideNameField() {
        Person person = mock(Person.class);
        when(person.getName()).thenReturn("Albert");

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals("Albert", personSummary.getName());
    }

    @Test
    public void shouldProvideLastNameField() {
        Person person = mock(Person.class);
        when(person.getLastName()).thenReturn("SomeLastName");

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals("S*****e", personSummary.getLastName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotProvideExplicitSex() {
        Person person = mock(Person.class);

        PersonSummary personSummary = new PersonSummary(person);

        personSummary.getSex();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotProvideExplicitBirthDate() {
        Person person = mock(Person.class);

        PersonSummary personSummary = new PersonSummary(person);

        personSummary.getBirthDate();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotProvideExplicitAnimals() {
        Person person = mock(Person.class);

        PersonSummary personSummary = new PersonSummary(person);

        personSummary.getAnimals();
    }

    @Test
    public void shouldHideAgeOf22As20() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(22);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Integer) 20, personSummary.getAge());
    }

    @Test
    public void shouldHideAgeOf23As25() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(23);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Integer) 25, personSummary.getAge());
    }

    @Test
    public void shouldHideAgeOf24As25() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(24);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Integer) 25, personSummary.getAge());
    }

    @Test
    public void shouldHideAgeOf25As25() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(25);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Integer) 25, personSummary.getAge());
    }

    @Test
    public void shouldHideAgeOf26As25() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(26);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Integer) 25, personSummary.getAge());
    }

    @Test
    public void shouldHideAgeOf27As25() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(27);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Integer) 25, personSummary.getAge());
    }

    @Test
    public void shouldHideAgeOf28As30() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(28);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Integer) 30, personSummary.getAge());
    }

    @Test
    public void shouldReturnCountOfDogs() {
        Animal animal1 = mock(Animal.class);
        when(animal1.getGenre()).thenReturn("DOG");
        Animal animal2 = mock(Animal.class);
        when(animal2.getGenre()).thenReturn("PARROT");
        Animal animal3 = mock(Animal.class);
        when(animal3.getGenre()).thenReturn("DOG");
        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        Person person = mock(Person.class);
        when(person.getAnimals()).thenReturn(animals);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Long) 2L, personSummary.getDogCount());
    }

    @Test
    public void shouldReturnCountOfCats() {
        Animal animal1 = mock(Animal.class);
        when(animal1.getGenre()).thenReturn("CAT");
        Animal animal2 = mock(Animal.class);
        when(animal2.getGenre()).thenReturn("CAT");
        Animal animal3 = mock(Animal.class);
        when(animal3.getGenre()).thenReturn("DOG");
        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        Person person = mock(Person.class);
        when(person.getAnimals()).thenReturn(animals);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Long) 2L, personSummary.getCatCount());
    }

    @Test
    public void shouldReturnCountOfParrots() {
        Animal animal1 = mock(Animal.class);
        when(animal1.getGenre()).thenReturn("CAT");
        Animal animal2 = mock(Animal.class);
        when(animal2.getGenre()).thenReturn("PARROT");
        Animal animal3 = mock(Animal.class);
        when(animal3.getGenre()).thenReturn("DOG");
        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        Person person = mock(Person.class);
        when(person.getAnimals()).thenReturn(animals);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Long) 1L, personSummary.getParrotCount());
    }

    @Test
    public void shouldReturnCountOfFish() {
        Animal animal1 = mock(Animal.class);
        when(animal1.getGenre()).thenReturn("FISH");
        Animal animal2 = mock(Animal.class);
        when(animal2.getGenre()).thenReturn("FISH");
        Animal animal3 = mock(Animal.class);
        when(animal3.getGenre()).thenReturn("FISH");
        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        Person person = mock(Person.class);
        when(person.getAnimals()).thenReturn(animals);

        PersonSummary personSummary = new PersonSummary(person);

        assertNotNull(personSummary);
        assertEquals((Long) 3L, personSummary.getFishCount());
    }

}