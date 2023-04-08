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

    private int getHeight() {
        return height;
    }

    @Override
    public void water() {
        System.out.println("Watering " + getPlantName() + ", a flowering plant");
    }
}