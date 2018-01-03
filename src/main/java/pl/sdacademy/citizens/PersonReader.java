package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Animal;
import pl.sdacademy.citizens.model.CsvFile;
import pl.sdacademy.citizens.model.CsvLine;
import pl.sdacademy.citizens.model.Person;
import pl.sdacademy.citizens.validation.PersonValidationRule;
import pl.sdacademy.citizens.validation.ValidationRule;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonReader {

    private ValidationRule personValidation;

    public PersonReader() {
        this.personValidation = new PersonValidationRule();
    }

    public List<Person> readFromFile(File fileName) throws ParseException {
        return readFromFile(fileName, new ArrayList<>());
    }
    public List<Person> readFromFile(File fileName, List<Animal> animals) throws ParseException {
        Map<Long, List<Animal>> animalsByPersonId = new AnimalListDecorator(Optional.ofNullable(animals).orElseGet(ArrayList::new)).groupById();
        CsvFile csvLines = CsvFile.fromFile(fileName);
        CsvFile rejectedPersons = new CsvFile();
        List<Person> persons = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (CsvLine csvLine : csvLines) {
            long personId = Long.parseLong(csvLine.getElementAt(0));
            Person person = Person.builder()
                    .id(personId)
                    .name(csvLine.getElementAt(1))
                    .lastName(csvLine.getElementAt(2))
                    .sex(csvLine.getElementAt(3))
                    .birthDate(csvLine.getElementAt(4))
                    .animals(animalsByPersonId.getOrDefault(personId, new ArrayList<>()))
                    .build();
            if (personValidation.isValid(person)) {
                persons.add(person);
            } else {
                CsvLine rejectedLine = new CsvLine(csvLine);
                rejectedLine.addElement(personValidation.validationMessage());
                rejectedPersons.addLine(rejectedLine);
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println(String.format("Converted %d in %d ms", persons.size(), (stop - start)));
        rejectedPersons.toFile(new File("rejectedRecords.csv"));
        System.out.println(String.format("Saved %d rejected records to %s", rejectedPersons.getLines().size(), "rejectedRecords.csv"));
        return persons;
    }
}
