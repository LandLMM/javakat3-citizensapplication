package pl.sdacademy.citizens.model;

import java.beans.Transient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final static long YEAR_IN_MILLISECONDS = (long) 1000 * 60 * 60 * 24 * 365;
    private final Long id;
    private final String name;
    private final String lastName;
    private final String sex;
    private final Date birthDate;
    private final Integer age;
    private final List<Animal> animals;

    private Person(Builder builder) throws ParseException {
        id = builder.id;
        name = builder.name;
        lastName = builder.lastName;
        sex = builder.sex;
        birthDate = DATE_FORMAT.parse(builder.birthDate);
        animals = new ArrayList<>(builder.animals);
        age = (int) ((System.currentTimeMillis() - birthDate.getTime()) / YEAR_IN_MILLISECONDS);
    }

    protected Person(Person person) {
        id = person.getId();
        name = person.getName();
        lastName = person.getLastName();
        sex = person.getSex();
        birthDate = person.getBirthDate();
        animals = new ArrayList<>(person.getAnimals());
        age = person.getAge();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Transient
    public Integer getAge() {
        return age;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String lastName;
        private String sex;
        private String birthDate;
        private List<Animal> animals = new ArrayList<>();

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder birthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder animals(List<Animal> animals) {
            this.animals = animals;
            return this;
        }

        public Person build() throws ParseException {
            return new Person(this);
        }
    }
}
