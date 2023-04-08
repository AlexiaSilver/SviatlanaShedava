package com.epam.javacourse.homework4;

import java.util.ArrayList;
import java.util.List;

public class GreenhouseManagement implements Greenhouse {

    public final List<Plant> plants;
    public double temperature;

    public GreenhouseManagement() {
        this.plants = new ArrayList<>();
        this.temperature = 0;
    }

    public void addPlant(Plant plant) {
        if (!plants.contains(plant)) {
            this.plants.add(plant);
            System.out.println("Plant " + plant.getPlantName() + " added to the greenhouse.");
        } else {
            System.out.println("Plant " + plant.getPlantName() + " is already in the greenhouse.");
        }
    }

    @Override
    public void createPlant(String plantName, String plantType, String nativeRegion) {
        Plant plant = new Plant(plantName, plantType, nativeRegion) {

            @Override
            public String getPlantType() {
                return null;
            }

            @Override
            public void water() {

            }
        };
        addPlant(plant);
    }

    @Override
    public void buyPlant(String plantName) {
        Plant plantToBuy = null;
        for (Plant plant : plants) {
            if (plant.getPlantName().equals(plantName)) {
                plantToBuy = plant;
                break;
            }
        }
        if (plantToBuy == null) {
            System.out.println("No plant with the given name found.");
        } else {
            plants.remove(plantToBuy);
            System.out.println("Plant " + plantName + " is bought.");
        }
    }

    @Override
    public void waterPlants() {
        for (Plant plant : this.plants) {
            plant.water();
        }
    }

    @Override
    public void removePlant(Plant plant) {
        this.plants.remove(plant);
        System.out.println("Plant " + plant.getPlantName() + " removed from the greenhouse.");
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.println("Temperature set to " + temperature + " degrees Celsius.");
    }

    @Override
    public List<Plant> getPlants() {
        return this.plants;
    }

    @Override
    public void updatePlant(Plant plant, String newName) {
        plant.setPlantName(newName);
        System.out.println("Plant " + plant.getPlantName() + " updated in the greenhouse.");
    }

    @Override
    public void createPlant(FloweringPlant newPlant) {

    }

    @Override
    public void createPlant(HousePlant newPlant) {

    }

    @Override
    public void createPlant(Shrub newPlant) {

    }

    /**
     * A static inner class that represents a temperature sensor for the greenhouse.
     */
    public class TemperatureSensor {
        public final double temperature;

        public TemperatureSensor(double temperature) {
            this.temperature = temperature;
        }

        public double getTemperature() {
            return temperature;
        }
    }
}
