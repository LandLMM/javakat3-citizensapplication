package pl.sdacademy.citizens.model;

import java.beans.Transient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final static long YEAR_IN_MILLISECONDS = (long) 1000 * 60 * 60 * 24 * 365;
    private Long id;
    private String name;
    private String lastName;
    private String sex;
    private Date birthDate;
    private Integer age;

    public Person() {
    }

    public Person(CsvLine line) throws ParseException {
        id = Long.parseLong(line.getElementAt(0));
        name = line.getElementAt(1);
        lastName = line.getElementAt(2);
        sex = line.getElementAt(3);
        birthDate = DATE_FORMAT.parse(line.getElementAt(4));
        age = (int) ((System.currentTimeMillis() - birthDate.getTime()) / YEAR_IN_MILLISECONDS);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Transient
    public Integer getAge() {
        return age;
    }
}
