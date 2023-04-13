package com.epam.javacourse.homework4;

import java.util.ArrayList;
import java.util.List;

public class GreenhouseManagement implements Greenhouse {
    private final List<Plant> reservedPlants;
    private final List<Plant> availablePlants;
    public double temperature;

    public GreenhouseManagement() {
        this.reservedPlants = new ArrayList<>();
        this.availablePlants = new ArrayList<>();
        this.temperature = 0;
    }

    public void addPlant(Plant plant) {
        if (!reservedPlants.contains(plant) && !availablePlants.contains(plant)) {
            this.availablePlants.add(plant);
            System.out.println("Plant " + plant.getPlantName() + " added to the list of available plants.");
        } else {
            System.out.println("Plant " + plant.getPlantName() + " is already in the greenhouse.");
        }
    }

    @Override
    public void buyPlant(String plantName) {
        Plant plantToBuy = null;
        for (Plant plant : availablePlants) {
            if (plant.getPlantName().equals(plantName)) {
                plantToBuy = plant;
                break;
            }
        }
        if (plantToBuy == null) {
            System.out.println("No plant with the given name found in the list of available plants.");
        } else {
            availablePlants.remove(plantToBuy);
            reservedPlants.add(plantToBuy);
            System.out.println("Plant " + plantName + " is bought and added to the greenhouse.");
        }
    }

    public List<Plant> getAvailablePlants() {
        return availablePlants;
    }

    public List<Plant> getReservedPlants() {
        return reservedPlants;
    }

    public abstract static class WateringSystem {
        public abstract void water(Plant plant);
    }

    @Override
    public void waterPlants() {
        WateringSystem wateringSystem = new WateringSystem() {
            @Override
            public void water(Plant plant) {
                System.out.println("Watering " + plant.getPlantName());
            }
        };
        for (Plant plant : this.reservedPlants) {
            wateringSystem.water(plant);
        }
    }

    @Override
    public void removePlant(Plant plant) {
        this.reservedPlants.remove(plant);
        System.out.println("Plant " + plant.getPlantName() + " removed from the greenhouse.");
    }

    @Override
    public List<Plant> getPlants() {
        return this.reservedPlants;
    }

    @Override
    public void updatePlant(Plant plant, String newName) {
        plant.setPlantName(newName);
        System.out.println("Plant " + plant.getPlantName() + " updated in the greenhouse.");
    }

    /**
     * A nested class that represents a garden tool for the greenhouse.
     */
    public class GardenTool {
        private final String name;

        public GardenTool(String name) {
            this.name = name;
        }

        public void use() {
            System.out.println("Using " + name + " to take care of the plants.");
        }
    }

    /**
     * A static inner class that represents a temperature sensor for the greenhouse.
     */
    public static class TemperatureSensor {
        private double temperature;

        public TemperatureSensor(double temperature) {
            this.temperature = temperature;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
            System.out.println("Temperature set to " + temperature + " degrees Celsius.");
        }
    }

    /**
     * An anonymous class that represents a mystery flower which is not available yet to be bought.
     */
    Greenhouse greenhouse = new Greenhouse() {
        private final List<Plant> mysteryPlant = new ArrayList<>() {{
            add(new Plant("Mystery Flower", "Unknown", "Unknown") {
                @Override
                public String getPlantType() {
                    return null;
                }
            });
        }};

        @Override
        public void buyPlant(String name) {
        }

        @Override
        public void waterPlants() {
            for (Plant plant : mysteryPlant) {
                System.out.println("Watering " + plant.getPlantName());
            }
        }

        @Override
        public void removePlant(Plant plant) {
        }

        @Override
        public List<Plant> getPlants() {
            return mysteryPlant;
        }

        @Override
        public void addPlant(Plant plant) {
        }

        @Override
        public void updatePlant(Plant plant, String newName) {
        }
    };
}

