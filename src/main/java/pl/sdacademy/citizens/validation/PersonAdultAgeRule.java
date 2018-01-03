package pl.sdacademy.citizens.validation;

import pl.sdacademy.citizens.model.Person;

import java.util.Optional;

public class PersonAdultAgeRule implements ValidationRule {
    @Override
    public boolean isValid(Person person) {
        Integer personAge = Optional.ofNullable(person).map(Person::getAge).orElse(-1);
        return personAge >= 18;
    }

    @Override
    public String validationMessage() {
        return "must be adult";
    }
}
