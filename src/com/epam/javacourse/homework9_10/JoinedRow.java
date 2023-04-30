package com.epam.javacourse.homework9_10;

public class JoinedRow {
    private final int gardenerId;
    private final String gardenerName;
    private final int age;
    private final String greenhouseName;
    private final String plantName;
    private final String variety;

    public JoinedRow(int gardenerId, String gardenerName, int age, String greenhouseName, String plantName, String variety) {
        this.gardenerId = gardenerId;
        this.gardenerName = gardenerName;
        this.age = age;
        this.greenhouseName = greenhouseName;
        this.plantName = plantName;
        this.variety = variety;
    }

    public int getGardenerId() {
        return gardenerId;
    }

    public String getGardenerName() {
        return gardenerName;
    }

    public int getAge() {
        return age;
    }

    public String getGreenhouseName() {
        return greenhouseName;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getVariety() {
        return variety;
    }
}
