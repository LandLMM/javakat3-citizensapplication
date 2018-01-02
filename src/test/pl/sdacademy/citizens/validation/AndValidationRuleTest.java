package pl.sdacademy.citizens.validation;

import org.junit.Before;
import org.junit.Test;
import pl.sdacademy.citizens.model.Person;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AndValidationRuleTest {

    private AndValidationRule rule;

    @Test
    public void shouldReturnTrueIfThereAreNoValidationRules() {
        rule = new AndValidationRule();

        boolean valid = rule.isValid(mock(Person.class));

        assertTrue(valid);
    }

    @Test
    public void shouldReturnTrueIfAllNestedRulesReturnTrue() {
        ValidationRule firstNestedRule = mock(ValidationRule.class);
        when(firstNestedRule.isValid(any())).thenReturn(true);
        ValidationRule secondNestedRule = mock(ValidationRule.class);
        when(secondNestedRule.isValid(any())).thenReturn(true);
        rule = new AndValidationRule(firstNestedRule, secondNestedRule);

        boolean valid = rule.isValid(mock(Person.class));

        assertTrue(valid);
    }

    @Test
    public void shouldReturnFalseIfOneNestedRulesReturnFalse() {
        ValidationRule firstNestedRule = mock(ValidationRule.class);
        when(firstNestedRule.isValid(any())).thenReturn(true);
        ValidationRule secondNestedRule = mock(ValidationRule.class);
        when(secondNestedRule.isValid(any())).thenReturn(false);
        rule = new AndValidationRule(firstNestedRule, secondNestedRule);

        boolean valid = rule.isValid(mock(Person.class));

        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseIfAllNestedRulesReturnFalse() {
        ValidationRule firstNestedRule = mock(ValidationRule.class);
        when(firstNestedRule.isValid(any())).thenReturn(false);
        ValidationRule secondNestedRule = mock(ValidationRule.class);
        when(secondNestedRule.isValid(any())).thenReturn(false);
        rule = new AndValidationRule(firstNestedRule, secondNestedRule);

        boolean valid = rule.isValid(mock(Person.class));

        assertFalse(valid);
    }

}