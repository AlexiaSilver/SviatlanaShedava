package com.epam.javacourse.homework4;

public abstract class Plant {
    public String name;
    public String type;
    public String nativeRegion;

    public Plant(String name, String type, String nativeRegion) {
        this.name = name;
        this.type = type;
        this.nativeRegion = nativeRegion;
    }

    public static void useGardenTool(GreenhouseManagement greenhouse, String toolName) {
        GreenhouseManagement.GardenTool tool = greenhouse.new GardenTool(toolName);
        tool.use();
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

    @Override
    public String toString() {
        return name + " (" + type + ") - Native to: " + nativeRegion;
    }
}
