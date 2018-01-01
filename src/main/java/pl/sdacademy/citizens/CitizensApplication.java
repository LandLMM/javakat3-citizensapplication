package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Person;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CitizensApplication {

    private PersonReader personReader;

    public CitizensApplication() {
        this.personReader = new PersonReader();
    }

    public void process() throws ParseException {
        File personFile = new File(getClass().getClassLoader().getResource("person.csv").getFile());
        List<Person> people = personReader.readFromFile(personFile);
        PersonListDecorator personListDecorator = new PersonListDecorator(people);

        Map<String, Long> nameSummary = personListDecorator.createNameSummary();
        // sample: how to print results to the console
//        for (Map.Entry<String, Long> nameCount : nameSummary.entrySet()) {
//            System.out.println("There are " + nameCount.getValue() + " persons with name " + nameCount.getKey());
//        }
    }
}
