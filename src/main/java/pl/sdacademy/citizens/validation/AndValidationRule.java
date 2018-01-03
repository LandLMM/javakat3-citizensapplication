package pl.sdacademy.citizens.validation;

import pl.sdacademy.citizens.model.Person;

import java.util.Optional;
import java.util.StringJoiner;

public class AndValidationRule implements ValidationRule {
    private final ValidationRule[] validationRules;
    private String lastValidationMessage;

    public AndValidationRule(ValidationRule... validationRules) {
        this.validationRules = validationRules;
    }

    @Override
    public boolean isValid(Person person) {
        StringJoiner validationMessageJoiner = new StringJoiner(" and ", "Person ", "");
        boolean validationResult = true;
        for (ValidationRule validationRule : validationRules) {
            if (!validationRule.isValid(person)) {
                validationMessageJoiner.add(validationRule.validationMessage());
                validationResult = false;
            }
        }
        lastValidationMessage = validationMessageJoiner.toString();
        return validationResult;
    }

    @Override
    public String validationMessage() {
        return lastValidationMessage;
    }
}
