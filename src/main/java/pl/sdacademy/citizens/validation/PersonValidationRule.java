package pl.sdacademy.citizens.validation;

import pl.sdacademy.citizens.model.Person;

public class PersonValidationRule extends AndValidationRule {

    public PersonValidationRule() {
        super(new PersonNameLengthRule(), new PersonLastNameLengthRule(), new PersonSexRule(), new PersonAdultAgeRule());
    }

}
