package pl.sdacademy.citizens.validation;

import pl.sdacademy.citizens.model.Person;

import java.util.Optional;

public class PersonLastNameLengthRule implements ValidationRule {
    @Override
    public boolean isValid(Person person) {
        return Optional.ofNullable(person).map(Person::getLastName).map(String::length).filter(length -> length > 2).isPresent();
    }

    @Override
    public String validationMessage() {
        return "last name must have at least 2 characters";
    }
}
