package com.epam.javacourse.homework9_10;

public class Gardener {
    private int id;
    private String name;
    private final int age;
    private final int greenhouseId;

    public Gardener(int id, String name, int age, int greenhouseId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.greenhouseId = greenhouseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getGreenhouseId() {
        return greenhouseId;
    }
}