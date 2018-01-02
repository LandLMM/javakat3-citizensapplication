package pl.sdacademy.citizens.validation;

import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.citizens.model.Person;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonSexRuleTest {

    private PersonSexRule rule;

    @Before
    public void init() {
        rule = new PersonSexRule();
    }

    @Test
    public void shouldReturnTrueIfSexIsUppercaseF() {
        Person person = mock(Person.class);
        when(person.getSex()).thenReturn("F");

        boolean valid = rule.isValid(person);

        assertTrue(valid);
    }

    @Test
    public void shouldReturnTrueIfSexIsLowercaseF() {
        Person person = mock(Person.class);
        when(person.getSex()).thenReturn("f");

        boolean valid = rule.isValid(person);

        assertTrue(valid);
    }

    @Test
    public void shouldReturnTrueIfSexIsUppercaseM() {
        Person person = mock(Person.class);
        when(person.getSex()).thenReturn("M");

        boolean valid = rule.isValid(person);

        assertTrue(valid);
    }

    @Test
    public void shouldReturnTrueIfSexIsLowercaseM() {
        Person person = mock(Person.class);
        when(person.getSex()).thenReturn("m");

        boolean valid = rule.isValid(person);

        assertTrue(valid);
    }

    @Test
    public void shouldReturnFalseIfSexIsUnknown() {
        Person person = mock(Person.class);
        when(person.getSex()).thenReturn("ASD");

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseIfSexIsNull() {
        Person person = mock(Person.class);
        when(person.getSex()).thenReturn(null);

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