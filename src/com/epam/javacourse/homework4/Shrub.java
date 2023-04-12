package com.epam.javacourse.homework4;

public class Shrub extends Plant {

    private final int height;

    public Shrub(String name, String type, String nativeRegion, int height) {
        super(name, type, nativeRegion);
        this.height = height;
    }

    @Override
    public String getPlantType() {
        return "Shrub";
    }

    @Override
    public String getNativeRegion() {
        return super.getNativeRegion();
    }

    @Override
    public String getPlantName() {
        return super.getPlantName();
    }

    @Override
    public String toString() {
        String output = "Name: " + getPlantName() + "\n";
        output += "Type: " + getPlantType() + "\n";
        output += "Native Region: " + getNativeRegion() + "\n";
        output += "Height: " + height + "\n";
        return output;
    }
}
