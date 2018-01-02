package pl.sdacademy.citizens;

import pl.sdacademy.citizens.model.Animal;
import pl.sdacademy.citizens.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalListDecorator extends ArrayList<Animal> {

    public AnimalListDecorator(Collection<? extends Animal> c) {
        super(c);
    }

    public Map<String, Long> countByGenre() {
        return stream().collect(Collectors.groupingBy(Animal::getGenre, Collectors.counting()));
    }
}
