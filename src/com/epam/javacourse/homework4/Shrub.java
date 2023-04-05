package com.epam.javacourse.homework4;

public class Shrub implements Plant {
    String name;
    String type;
    String nativeRegion;

    @Override
    public void createPlant(String name, String type, String nativeRegion) {
        this.name = name;
        this.type = type;
        this.nativeRegion = nativeRegion;
        System.out.println(type + " is created.");
    }

    @Override
    public void updatePlant(String name, String type, String nativeRegion) {
        this.name = name;
        this.type = type;
        this.nativeRegion = nativeRegion;
        System.out.println(type + " is updated.");
    }

    @Override
    public void removePlant(String name) {
        this.name = name;
        System.out.println(name + " is removed from Greenhouse.");
    }

    @Override
    public String getPlantType() {

        return type;
    }

    @Override
    public String getNativeRegion() {

        return nativeRegion;
    }

    @Override
    public String getPlantName() {

        return name;
    }

    public static void specificShrubMethod() {

    }
}

