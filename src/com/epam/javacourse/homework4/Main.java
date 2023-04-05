package com.epam.javacourse.homework4;

public class Main {
    public static void main(String[] args) {
        GreenhouseManagement greenhouse = new GreenhouseManagement();

        Shrub shrub = new Shrub();
        shrub.createPlant("Azalea", "Shrub", "Asia");
            System.out.println("Name: " + shrub.getPlantName());
            System.out.println("Type: " + shrub.getPlantType());
            System.out.println("Native region: " + shrub.getNativeRegion());
        greenhouse.buyPlant(shrub);
        Shrub.specificShrubMethod();
        System.out.println("A shrub is a small to medium sized woody plant.");
        System.out.println();

        FloweringPlant floweringPlant = new FloweringPlant();
        floweringPlant.createPlant("Lily", "Flowering plant", "Europe");
            System.out.println("Name: " + floweringPlant.getPlantName());
            System.out.println("Type: " + floweringPlant.getPlantType());
            System.out.println("Native region: " + floweringPlant.getNativeRegion());
        greenhouse.buyPlant(floweringPlant);
        FloweringPlant.specificFloweringPlantMethod();
        System.out.println("There are over 300,000 different species of flowering plants in the world!");
        System.out.println();

        HousePlant housePlant = new HousePlant();
        housePlant.createPlant("Aloe vera", "House plant", "Arabian Peninsula");
            System.out.println("Name: " + housePlant.getPlantName());
            System.out.println("Type: " + housePlant.getPlantType());
            System.out.println("Native region: " + housePlant.getNativeRegion());
        greenhouse.buyPlant(housePlant);
        HousePlant.specificHousePlantMethod();
        System.out.println("House plants love music.");
        System.out.println();

        greenhouse.waterPlants();
        System.out.println();

        int temperature = 25;
        greenhouse.setTemperature(temperature);
        System.out.println();

        greenhouse.removePlant(shrub);
    }
}
