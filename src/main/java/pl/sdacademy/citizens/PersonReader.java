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
            persons.add(
                    Person.builder()
                            .id(Long.parseLong(csvLine.getElementAt(0)))
                            .name(csvLine.getElementAt(1))
                            .lastName(csvLine.getElementAt(2))
                            .sex(csvLine.getElementAt(3))
                            .birthDate(csvLine.getElementAt(4))
                            .build());
        }
        long stop = System.currentTimeMillis();
        System.out.println("Converted " + persons.size() + " in " + (stop - start) + " ms");
        return persons;
    }
}
