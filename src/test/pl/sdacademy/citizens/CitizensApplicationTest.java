package pl.sdacademy.citizens;

import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.citizens.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CitizensApplicationTest {

    private CitizensApplication citizensApplication;

    @Before
    public void init() {
        citizensApplication = new CitizensApplication();
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

        Map<String, Long> peopleCountByLastName = citizensApplication.countByLastName(personList);

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

        Map<String, List<Person>> peopleGroupedByName = citizensApplication.groupByName(personList);

        assertNotNull(peopleGroupedByName);
        assertEquals(1, peopleGroupedByName.get("Name-1").size());
        assertEquals(1, peopleGroupedByName.get("Name-2").size());
        assertEquals(2, peopleGroupedByName.get("Name-3").size());
        assertEquals(2, peopleGroupedByName.get("Name-4").size());
    }

}