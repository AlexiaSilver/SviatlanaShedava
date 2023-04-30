package com.epam.javacourse.homework9_10;

public class Greenhouse {
    private final int id;
    private final String name;
    private final String address;

    public Greenhouse(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
