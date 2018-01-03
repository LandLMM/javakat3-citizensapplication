package pl.sdacademy.citizens;

import org.junit.Test;
import pl.sdacademy.citizens.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimalListDecoratorTest {

    @Test
    public void shouldCountAnimalsByGenre() {
        Animal animal1 = mock(Animal.class);
        when(animal1.getGenre()).thenReturn("Genre-1");
        Animal animal2 = mock(Animal.class);
        when(animal2.getGenre()).thenReturn("Genre-2");
        Animal animal3 = mock(Animal.class);
        when(animal3.getGenre()).thenReturn("Genre-2");
        Animal animal4 = mock(Animal.class);
        when(animal4.getGenre()).thenReturn("Genre-2");
        Animal animal5 = mock(Animal.class);
        when(animal5.getGenre()).thenReturn("Genre-3");
        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);

        AnimalListDecorator animalListDecorator = new AnimalListDecorator(animals);
        Map<String, Long> animalsByGenre = animalListDecorator.countByGenre();

        assertNotNull(animalsByGenre);
        assertEquals((Long) 1L, animalsByGenre.get("Genre-1"));
        assertEquals((Long) 3L, animalsByGenre.get("Genre-2"));
        assertEquals((Long) 1L, animalsByGenre.get("Genre-3"));
    }

    @Test
    public void shouldGroupAnimalsById() {
        Animal animal1 = mock(Animal.class);
        when(animal1.getId()).thenReturn(1L);
        Animal animal2 = mock(Animal.class);
        when(animal2.getId()).thenReturn(1L);
        Animal animal3 = mock(Animal.class);
        when(animal3.getId()).thenReturn(2L);
        Animal animal4 = mock(Animal.class);
        when(animal4.getId()).thenReturn(2L);
        Animal animal5 = mock(Animal.class);
        when(animal5.getId()).thenReturn(3L);
        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        animals.add(animal5);

        AnimalListDecorator animalListDecorator = new AnimalListDecorator(animals);
        Map<Long, List<Animal>> animalsById = animalListDecorator.groupById();

        assertNotNull(animalsById);
        assertEquals(2, animalsById.get(1L).size());
        assertEquals(2, animalsById.get(2L).size());
        assertEquals(1, animalsById.get(3L).size());
    }
}