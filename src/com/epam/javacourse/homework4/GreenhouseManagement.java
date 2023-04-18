package com.epam.javacourse.homework4;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GreenhouseManagement implements Greenhouse {
    private final Path path;
    private final List<Plant> reservedPlants;
    private final List<Plant> availablePlants;
    public double temperature;

    public GreenhouseManagement(Path path) {
        this.path = path;
        this.reservedPlants = new ArrayList<>();
        this.availablePlants = new ArrayList<>();
        this.temperature = 0;
    }

    public void addPlant(Plant plant) {
        if (!reservedPlants.contains(plant) && !availablePlants.contains(plant)) {
            this.availablePlants.add(plant);
            savePlantsToFile();
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

    @Override
    public void waterPlants() {
        for (Plant plant : this.availablePlants) {
            System.out.println("Watering " + plant.getPlantName());
        }
    }

    @Override
    public void removePlant(String plantName) throws InvalidOptionException {
        Plant plantToRemove = null;
        for (Plant plant : availablePlants) {
            if (plant.getPlantName().equalsIgnoreCase(plantName)) {
                plantToRemove = plant;
                break;
            }
        }
        if (plantToRemove == null) {
            throw new InvalidOptionException("Plant " + plantName + " not found in the greenhouse.");
        }
        availablePlants.remove(plantToRemove);
        savePlantsToFile();
        System.out.println("Plant " + plantToRemove.getPlantName() + " removed from the greenhouse.");
    }

    @Override
    public void savePlantsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(String.valueOf(path)))) {
            for (Plant plant : availablePlants) {
                writer.println(plant.toString());
            }
        } catch (IOException e) {
            System.err.println("Error saving plants to file: " + e.getMessage());
        }
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
            System.out.println("Not available.");
        }

        @Override
        public void waterPlants() {
            for (Plant plant : mysteryPlant) {
                System.out.println("Watering " + plant.getPlantName());
            }
        }

        @Override
        public List<Plant> getPlants() {
            return mysteryPlant;
        }

        @Override
        public void addPlant(Plant plant) {
            System.out.println("The plant is still growing..");
        }

        @Override
        public void updatePlant(Plant plant, String newName) {
            System.out.println("Not available.");
        }

        @Override
        public void removePlant(String plantName) throws InvalidOptionException {
            System.out.println("Not available.");

        }

        @Override
        public void savePlantsToFile() {
            System.out.println("Not available.");
        }
    };

    public List<Plant> searchPlants(String searchTerm) {
        List<Plant> matchingPlants = new ArrayList<>();
        for (Plant plant : availablePlants) {
            if (plant.getPlantName().toLowerCase().matches("\\b" + searchTerm.toLowerCase() + "\\b") ||
                    plant.getPlantType().toLowerCase().matches("\\b" + searchTerm.toLowerCase() + "\\b") ||
                    plant.getNativeRegion().toLowerCase().matches("\\b" + searchTerm.toLowerCase() + "\\b")) {
                matchingPlants.add(plant);
            }
        }
        if (matchingPlants.isEmpty()) {
        }
        return matchingPlants;
    }
}
