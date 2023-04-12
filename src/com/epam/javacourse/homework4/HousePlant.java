package com.epam.javacourse.homework4;

public class HousePlant extends Plant {

    private final boolean hasNeedForSunlight;

    public HousePlant(String name, String type, String nativeRegion, boolean hasNeedForSunlight) {
        super(name, type, nativeRegion);
        this.hasNeedForSunlight = hasNeedForSunlight;
    }

    @Override
    public String getPlantType() {
        return "House Plant";
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
        output += "Requires Sunlight: " + hasNeedForSunlight + "\n";
        return output;
    }
}
