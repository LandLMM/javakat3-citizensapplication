package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PersonListDecorator extends ArrayList<Person> {

    public PersonListDecorator(Collection<? extends Person> c) {
        super(c);
    }

    public Map<String, Long> createNameSummary() {
        return stream().collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
    }

    public Map<String,Long> countByLastName() {
        return stream().collect(Collectors.groupingBy(Person::getLastName, Collectors.counting()));
    }

    public Map<String,List<Person>> groupByName() {
        return stream().collect(Collectors.groupingBy(Person::getName, Collectors.toList()));
    }

    public List<Person> filterWithAgeBetween35and55() {
        return stream().filter(person -> person.getAge() >= 35).filter(person -> person.getAge() <= 55).collect(Collectors.toList());
    }

    public Long countPossiblyRetired() {
        return stream().filter(this::canBeRetired).count();
    }

    private boolean canBeRetired(Person person) {
        return possiblyRetiredFemale(person) || possiblyRetiredMale(person);
    }

    private boolean possiblyRetiredFemale(Person person) {
        return "F".equals(person.getSex()) && person.getAge() >= 60;
    }

    private boolean possiblyRetiredMale(Person person) {
        return "M".equals(person.getSex()) && person.getAge() >= 65;
    }

    public List<Person> filterWithAtLeastTwoAnimals() {
        return stream().filter(person -> person.getAnimals().size() >= 2).collect(Collectors.toList());
    }
}
