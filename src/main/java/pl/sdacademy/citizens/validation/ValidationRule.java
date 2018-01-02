package pl.sdacademy.citizens.validation;

import pl.sdacademy.citizens.model.Person;

public interface ValidationRule {
    boolean isValid(Person person);
}
