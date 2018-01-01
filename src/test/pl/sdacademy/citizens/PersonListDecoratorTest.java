package pl.sdacademy.citizens;

import org.junit.Test;
import pl.sdacademy.citizens.model.Person;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonListDecoratorTest {

    public void shouldUsePersonListToInitialize() {
        List<Person> personList = new ArrayList<>();

        PersonListDecorator decorator = new PersonListDecorator(personList);

        assertNotNull(decorator);
    }

    @Test
    public void shouldBeAbleToCountPersonByLastName() {
        Person person1 = mock(Person.class);
        when(person1.getLastName()).thenReturn("LastName-1");
        Person person2 = mock(Person.class);
        when(person2.getLastName()).thenReturn("LastName-1");
        Person person3 = mock(Person.class);
        when(person3.getLastName()).thenReturn("LastName-1");
        Person person4 = mock(Person.class);
        when(person4.getLastName()).thenReturn("LastName-2");
        Person person5 = mock(Person.class);
        when(person5.getLastName()).thenReturn("LastName-2");
        Person person6 = mock(Person.class);
        when(person6.getLastName()).thenReturn("LastName-3");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);

        PersonListDecorator personListDecorator = new PersonListDecorator(personList);
        Map<String, Long> peopleCountByLastName = personListDecorator.countByLastName();

        assertNotNull(peopleCountByLastName);
        assertEquals((Long) 3L, peopleCountByLastName.get("LastName-1"));
        assertEquals((Long) 2L, peopleCountByLastName.get("LastName-2"));
        assertEquals((Long) 1L, peopleCountByLastName.get("LastName-3"));
    }

    @Test
    public void shouldBeAbleToGroupPersonByName() {
        Person person1 = mock(Person.class);
        when(person1.getName()).thenReturn("Name-1");
        Person person2 = mock(Person.class);
        when(person2.getName()).thenReturn("Name-2");
        Person person3 = mock(Person.class);
        when(person3.getName()).thenReturn("Name-3");
        Person person4 = mock(Person.class);
        when(person4.getName()).thenReturn("Name-3");
        Person person5 = mock(Person.class);
        when(person5.getName()).thenReturn("Name-4");
        Person person6 = mock(Person.class);
        when(person6.getName()).thenReturn("Name-4");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);

        PersonListDecorator personListDecorator = new PersonListDecorator(personList);
        Map<String, List<Person>> peopleGroupedByName = personListDecorator.groupByName();

        assertNotNull(peopleGroupedByName);
        assertEquals(1, peopleGroupedByName.get("Name-1").size());
        assertEquals(1, peopleGroupedByName.get("Name-2").size());
        assertEquals(2, peopleGroupedByName.get("Name-3").size());
        assertEquals(2, peopleGroupedByName.get("Name-4").size());
    }

    @Test
    public void shouldBeAbleToFilterByAge() throws ParseException {
        Person person1 = mock(Person.class);
        when(person1.getAge()).thenReturn(25);
        Person person2 = mock(Person.class);
        when(person2.getAge()).thenReturn(35);
        Person person3 = mock(Person.class);
        when(person3.getAge()).thenReturn(45);
        Person person4 = mock(Person.class);
        when(person4.getAge()).thenReturn(55);
        Person person5 = mock(Person.class);
        when(person5.getAge()).thenReturn(65);
        Person person6 = mock(Person.class);
        when(person6.getAge()).thenReturn(75);
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);

        PersonListDecorator personListDecorator = new PersonListDecorator(personList);
        List<Person> filteredPeople = personListDecorator.filterWithAgeBetween35and55();

        assertNotNull(filteredPeople);
        assertEquals(3, filteredPeople.size());
        assertTrue(filteredPeople.contains(person2));
        assertTrue(filteredPeople.contains(person3));
        assertTrue(filteredPeople.contains(person4));
    }

    @Test
    public void shouldCountPeopleThatCanBeRetired() throws ParseException {
        Person person1 = mock(Person.class);
        when(person1.getAge()).thenReturn(59);
        when(person1.getSex()).thenReturn("F");
        Person person2 = mock(Person.class);
        when(person2.getAge()).thenReturn(60);
        when(person2.getSex()).thenReturn("F");
        Person person3 = mock(Person.class);
        when(person3.getAge()).thenReturn(61);
        when(person3.getSex()).thenReturn("F");
        Person person4 = mock(Person.class);
        when(person4.getAge()).thenReturn(64);
        when(person4.getSex()).thenReturn("M");
        Person person5 = mock(Person.class);
        when(person5.getAge()).thenReturn(65);
        when(person5.getSex()).thenReturn("M");
        Person person6 = mock(Person.class);
        when(person6.getAge()).thenReturn(66);
        when(person6.getSex()).thenReturn("M");
        Person person7 = mock(Person.class);
        when(person7.getAge()).thenReturn(99);
        when(person7.getSex()).thenReturn("X");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);

        PersonListDecorator personListDecorator = new PersonListDecorator(personList);
        Long possiblyRetired = personListDecorator.countPossiblyRetired();

        assertNotNull(possiblyRetired);
        assertEquals((Long) 4L, possiblyRetired);
    }

}