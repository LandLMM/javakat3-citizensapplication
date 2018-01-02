package pl.sdacademy.citizens.validation;

import pl.sdacademy.citizens.model.Person;

import java.util.Optional;

public class AndValidationRule implements ValidationRule {
    private final ValidationRule[] validationRules;

    public AndValidationRule(ValidationRule... validationRules) {
        this.validationRules = validationRules;
    }

    @Override
    public boolean isValid(Person person) {
        boolean validationResult = true;
        for (ValidationRule validationRule : validationRules) {
            validationResult &= validationRule.isValid(person);
        }
        return validationResult;
    }
}
