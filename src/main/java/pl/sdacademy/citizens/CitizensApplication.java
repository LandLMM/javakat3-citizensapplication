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

        Map<String, Long> nameSummary = createNameSummary(people);
        // sample: how to print results to the console
//        for (Map.Entry<String, Long> nameCount : nameSummary.entrySet()) {
//            System.out.println("There are " + nameCount.getValue() + " persons with name " + nameCount.getKey());
//        }
    }

    private Map<String, Long> createNameSummary(List<Person> people) {
        Map<String, Long> nameCount = new HashMap<>();
        for (Person person : people) {
            String name = person.getName();
            Long peopleWithTheSameNameCount = nameCount.getOrDefault(name, 0L);
            peopleWithTheSameNameCount++;
            nameCount.put(name, peopleWithTheSameNameCount);
        }
        return nameCount;
    }


    public Map<String,Long> countByLastName(List<Person> personList) {
        Map<String,Long> countedByLastName = new HashMap<>();
        for (Person person : personList) {
            countedByLastName.merge(person.getLastName(), 1L, (previousCount, countToAdd) -> previousCount + countToAdd);
        }
        return countedByLastName;
    }

    public Map<String,List<Person>> groupByName(List<Person> personList) {
        Map<String,List<Person>> groupedByName = new HashMap<>();
        for (Person person : personList) {
            List<Person> listOfPeopleWithTheSameName = groupedByName.getOrDefault(person.getName(), new ArrayList<>());
            listOfPeopleWithTheSameName.add(person);
            groupedByName.put(person.getName(), listOfPeopleWithTheSameName);
        }
        return groupedByName;
    }

    public List<Person> filterWithAgeBetween35and55(List<Person> personList) {
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : personList) {
            Integer age = person.getAge();
            if (age >= 35 && age <= 55) {
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }

    public Long countPossiblyRetired(List<Person> personList) {
        Long possiblyRetired = 0L;
        for (Person person : personList) {
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
