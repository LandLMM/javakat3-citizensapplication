package pl.sdacademy.citizens.validation;

import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.citizens.model.Person;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonAdultAgeRuleTest {

    private PersonAdultAgeRule rule;

    @Before
    public void init() {
        rule = new PersonAdultAgeRule();
    }

    @Test
    public void shouldReturnTrueIfAgeIs18() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(18);

        boolean valid = rule.isValid(person);

        assertTrue(valid);
    }

    @Test
    public void shouldReturnTrueIfAgeIs19() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(19);

        boolean valid = rule.isValid(person);

        assertTrue(valid);
    }

    @Test
    public void shouldReturnFalseIfAgeIs17() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(17);

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseIfAgeIsNegative() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(-10);

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseIfAgeIsNull() {
        Person person = mock(Person.class);
        when(person.getAge()).thenReturn(null);

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseIfPersonIsNull() {
        Person person = null;

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

}