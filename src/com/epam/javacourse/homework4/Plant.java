package com.epam.javacourse.homework4;

public abstract class Plant {
    public String name;
    private String type;
    private String nativeRegion;

    public Plant(String name, String type, String nativeRegion) {
        this.name = name;
        this.type = type;
        this.nativeRegion = nativeRegion;
    }

    public String getPlantName() {
        return name;
    }

    public abstract String getPlantType();

    public String getNativeRegion() {
        return nativeRegion;
    }

    public void setPlantName(String name) {
        this.name = name;
    }

    public void setPlantType(String type) {
        this.type = type;
    }

    public void setNativeRegion(String nativeRegion) {
        this.nativeRegion = nativeRegion;
    }

    public String toString() {
        String output = "Name: " + name + "\n";
        output += "Type: " + type + "\n";
        output += "Native Region: " + nativeRegion + "\n";
        return output;
    }

    public abstract void water();
}