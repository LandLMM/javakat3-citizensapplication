package pl.sdacademy.citizens.validation;

import pl.sdacademy.citizens.model.Person;

import java.util.Optional;

public class PersonSexRule implements ValidationRule {
    @Override
    public boolean isValid(Person person) {
        // czytane:
        // weź obiekt person, jeżeli obiekt person istnieje, to pobierz jego "sex". Jeżeli sex nie istnieje, to zwróć
        // pusty string ""
        String personSex = Optional.ofNullable(person).map(Person::getSex).orElse("");
        return personSex.equalsIgnoreCase("F") || personSex.equalsIgnoreCase("M");
    }
}
