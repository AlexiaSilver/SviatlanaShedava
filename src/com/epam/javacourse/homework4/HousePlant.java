package com.epam.javacourse.homework4;

public class HousePlant extends Plant {

    private final boolean needsSunlight;

    public HousePlant(String name, String type, String nativeRegion, boolean needsSunlight) {
        super(name, type, nativeRegion);
        this.needsSunlight = needsSunlight;
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
    public void water() {
        System.out.println("Watering " + getPlantName() + ", a flowering plant");
    }

    public boolean isNeedsSunlight() {
        return needsSunlight;
    }
}
