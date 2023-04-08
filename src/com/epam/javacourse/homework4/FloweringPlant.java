package com.epam.javacourse.homework4;

public class FloweringPlant extends Plant {

    public FloweringPlant(String name, String type, String nativeRegion, int floweringTime) {
        super(name, type, nativeRegion);
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
        return name;
    }

    @Override
    public void water() {
        System.out.println("Watering " + getPlantName() + ", a flowering plant");
    }
}