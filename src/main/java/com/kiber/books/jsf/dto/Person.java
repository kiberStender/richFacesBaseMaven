package com.kiber.books.jsf.dto;

/**
 * Created by sirkleber on 28/04/16.
 */
public class Person {
    private Long id;
    private String name;
    private String surname;

    public Person() {
        id = -1L;
        name = "Teste";
        surname = "";
    }

    public Person(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
