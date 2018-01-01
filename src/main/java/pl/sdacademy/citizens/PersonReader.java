package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.CsvFile;
import pl.sdacademy.citizens.model.CsvLine;
import pl.sdacademy.citizens.model.Person;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
    public List<Person> readFromFile(File fileName) throws ParseException {
        CsvFile csvLines = CsvFile.fromFile(fileName);
        List<Person> persons = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (CsvLine csvLine : csvLines) {
            Person person = Person.builder()
                    .id(Long.parseLong(csvLine.getElementAt(0)))
                    .name(csvLine.getElementAt(1))
                    .lastName(csvLine.getElementAt(2))
                    .sex(csvLine.getElementAt(3))
                    .birthDate(csvLine.getElementAt(4))
                    .build();
            if (isValid(person)) {
                persons.add(person);
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println("Converted " + persons.size() + " in " + (stop - start) + " ms");
        return persons;
    }

    private boolean isValid(Person person) {
        if (person.getName() == null || person.getName().length() <= 2) {
            return false;
        }
        if (person.getLastName() == null || person.getLastName().length() <= 2) {
            return false;
        }
        if (!("F".equals(person.getSex()) || "M".equals(person.getSex()))) {
            return false;
        }
        if (person.getBirthDate().getTime() > System.currentTimeMillis()) {
            return false;
        }
        return person.getAge() > 18;
    }
}
