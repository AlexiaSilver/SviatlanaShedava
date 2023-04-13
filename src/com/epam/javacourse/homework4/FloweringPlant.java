package com.epam.javacourse.homework4;

public class FloweringPlant extends Plant {

    private final int floweringTime;

    public FloweringPlant(String name, String type, String nativeRegion, int floweringTime) {
        super(name, type, nativeRegion);
        this.floweringTime = floweringTime;
    }

    @Override
    public String getPlantType() {
        return "Flowering Plant";
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
        output += "Flowering Time: " + floweringTime + "\n";
        return output;
    }
}
