package pl.sdacademy.citizens.validation;

import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.citizens.model.Person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonLastNameLengthRuleTest {

    private PersonLastNameLengthRule rule;

    @Before
    public void init() {
        rule = new PersonLastNameLengthRule();
    }

    @Test
    public void shouldReturnTrueWhenLastNameHas3Letters() {
        Person person = mock(Person.class);
        when(person.getLastName()).thenReturn("Xyz");

        boolean valid = rule.isValid(person);

        assertTrue(valid);
    }

    @Test
    public void shouldReturnFalseWhenLastNameHas2Letters() {
        Person person = mock(Person.class);
        when(person.getLastName()).thenReturn("Xy");

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseWhenLastNameHas0Letters() {
        Person person = mock(Person.class);
        when(person.getLastName()).thenReturn("");

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseWhenLastNameIsNull() {
        Person person = mock(Person.class);
        when(person.getLastName()).thenReturn(null);

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseWhenPersonIsNull() {
        Person person = null;

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

}