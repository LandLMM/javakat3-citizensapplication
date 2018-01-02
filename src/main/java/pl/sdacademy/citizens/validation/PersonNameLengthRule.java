package pl.sdacademy.citizens.validation;

import pl.sdacademy.citizens.model.Person;

import java.util.Optional;

public class PersonNameLengthRule implements ValidationRule {
    @Override
    public boolean isValid(Person person) {
        // czytane:
        // weź obiekt Person, jeżeli istnieje obiekt person, to pobierz jego "name". Jeżeli name istnieje, to pobierz
        // długość tego "name". Jeżeli długość name jest większa od 2, to zwróć "true"
        return Optional.ofNullable(person).map(Person::getName).map(String::length).filter(length -> length > 2).isPresent();
    }
}
