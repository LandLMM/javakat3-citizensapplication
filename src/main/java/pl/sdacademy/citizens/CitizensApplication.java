package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Animal;
import pl.sdacademy.citizens.model.Person;
import pl.sdacademy.citizens.model.PersonSummary;
import pl.sdacademy.citizens.validation.PersonSummaryWriter;

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
    private AnimalReader animalReader;

    public CitizensApplication() {
        this.personReader = new PersonReader();
        this.animalReader = new AnimalReader();
    }

    public void process() throws ParseException {
        File animalFile = new File(getClass().getClassLoader().getResource("animal.csv").getFile());
        List<Animal> animals = animalReader.readFromFile(animalFile);

        File personFile = new File(getClass().getClassLoader().getResource("person.csv").getFile());
        List<Person> people = personReader.readFromFile(personFile, animals);
        PersonListDecorator personListDecorator = new PersonListDecorator(people);

        List<PersonSummary> personSummary = personListDecorator.getSummary();
        PersonSummaryWriter summaryWriter = new PersonSummaryWriter();
        summaryWriter.writeToFile(new File("summary.csv"), personSummary);
    }
}
