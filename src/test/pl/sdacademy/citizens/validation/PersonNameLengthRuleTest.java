package pl.sdacademy.citizens.validation;

import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.citizens.model.Person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonNameLengthRuleTest {

    private PersonNameLengthRule rule;

    @Before
    public void init() {
        rule = new PersonNameLengthRule();
    }

    @Test
    public void shouldReturnTrueWhenNameHas3Letters() {
        Person person = mock(Person.class);
        when(person.getName()).thenReturn("Abc");

        boolean valid = rule.isValid(person);

        assertTrue(valid);
    }

    @Test
    public void shouldReturnFalseWhenNameHas2Letters() {
        Person person = mock(Person.class);
        when(person.getName()).thenReturn("Ab");

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseWhenNameHas0Letters() {
        Person person = mock(Person.class);
        when(person.getName()).thenReturn("");

        boolean valid = rule.isValid(person);

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseWhenNameIsNull() {
        Person person = mock(Person.class);
        when(person.getName()).thenReturn(null);

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