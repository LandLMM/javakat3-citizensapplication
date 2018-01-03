package pl.sdacademy.citizens.model;

import java.util.Optional;

public class Animal {
    private Long id;
    private String name;
    private String genre;

    public Animal()  {
    }

    public Animal(CsvLine line)  {
        id = Long.parseLong(Optional.ofNullable(line.getElementAt(0)).orElse("-1"));
        name = line.getElementAt(1);
        genre = line.getElementAt(2);
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
