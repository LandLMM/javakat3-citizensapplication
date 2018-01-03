package pl.sdacademy.citizens.model;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

public class PersonSummary extends Person {

    public PersonSummary(Person person) {
        super(person);
    }

    @Override
    public String getLastName() {
        String originalLastName = super.getLastName();
        String firstLetter = originalLastName.substring(0, 1);
        String lastLetter = originalLastName.substring(originalLastName.length() - 1, originalLastName.length());
        return firstLetter + "*****" + lastLetter ;
    }

    @Override
    public String getSex() {
        throw new UnsupportedOperationException("Summary does not provide sex information");
    }

    @Override
    public Date getBirthDate() {
        throw new UnsupportedOperationException("Summary does not provide explicit birth date information");
    }

    @Override
    public List<Animal> getAnimals() {
        throw new UnsupportedOperationException("Summary does not provide explicit animal information");
    }

    @Transient
    public Integer getAge() {
        Integer originalAge = super.getAge();
        return ((originalAge + 2) / 5) * 5;
    }

    public Long getDogCount() {
        return super.getAnimals().stream().filter(animal -> animal.getGenre().equalsIgnoreCase("dog")).count();
    }

    public Long getCatCount() {
        return super.getAnimals().stream().filter(animal -> animal.getGenre().equalsIgnoreCase("cat")).count();
    }

    public Long getParrotCount() {
        return super.getAnimals().stream().filter(animal -> animal.getGenre().equalsIgnoreCase("parrot")).count();
    }

    public Long getFishCount() {
        return super.getAnimals().stream().filter(animal -> animal.getGenre().equalsIgnoreCase("fish")).count();
    }
}
