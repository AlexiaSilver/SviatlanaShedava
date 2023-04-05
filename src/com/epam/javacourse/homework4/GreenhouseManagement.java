package com.epam.javacourse.homework4;

public class GreenhouseManagement implements Greenhouse {

    public GreenhouseManagement() {
    }

    @Override
    public void buyPlant(Plant plant) {
            System.out.println("Plant is bought.");
    }

    @Override
    public void waterPlants() {
        System.out.println("Watering plants...");
    }

    @Override
    public void setTemperature(int temperature) {
        System.out.println("Temperature is set to " + temperature + " degrees Celsius.");
    }

    @Override
    public void removePlant(Plant plant) {
        plant.removePlant(plant.getPlantName());
    }
}

