package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Person;

import java.util.*;

public class PersonListDecorator extends ArrayList<Person> {

    public PersonListDecorator(Collection<? extends Person> c) {
        super(c);
    }

    public Map<String, Long> createNameSummary() {
        Map<String, Long> nameCount = new HashMap<>();
        for (Person person : this) {
            String name = person.getName();
            Long peopleWithTheSameNameCount = nameCount.getOrDefault(name, 0L);
            peopleWithTheSameNameCount++;
            nameCount.put(name, peopleWithTheSameNameCount);
        }
        return nameCount;
    }


    public Map<String,Long> countByLastName() {
        Map<String,Long> countedByLastName = new HashMap<>();
        for (Person person : this) {
            countedByLastName.merge(person.getLastName(), 1L, (previousCount, countToAdd) -> previousCount + countToAdd);
        }
        return countedByLastName;
    }

    public Map<String,List<Person>> groupByName() {
        Map<String,List<Person>> groupedByName = new HashMap<>();
        for (Person person : this) {
            List<Person> listOfPeopleWithTheSameName = groupedByName.getOrDefault(person.getName(), new ArrayList<>());
            listOfPeopleWithTheSameName.add(person);
            groupedByName.put(person.getName(), listOfPeopleWithTheSameName);
        }
        return groupedByName;
    }

    public List<Person> filterWithAgeBetween35and55() {
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : this) {
            Integer age = person.getAge();
            if (age >= 35 && age <= 55) {
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }

    public Long countPossiblyRetired() {
        Long possiblyRetired = 0L;
        for (Person person : this) {
            if (possiblyRetiredFemale(person) || possiblyRetiredMale(person)) {
                possiblyRetired++;
            }
        }
        return possiblyRetired;
    }

    private boolean possiblyRetiredFemale(Person person) {
        return "F".equals(person.getSex()) && person.getAge() >= 60;
    }

    private boolean possiblyRetiredMale(Person person) {
        return "M".equals(person.getSex()) && person.getAge() >= 65;
    }
}
