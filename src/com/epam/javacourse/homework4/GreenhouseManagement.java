package com.epam.javacourse.homework4;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GreenhouseManagement implements Greenhouse {
    private static final Path FILE_NAME = Paths.get("C:\\Users\\Sviatlana_Shedava\\IdeaProjects\\SviatlanaShedava5\\src\\com\\epam\\javacourse\\homework4\\plants.txt");
    private static final String DELIMITER = ";";
    private final List<Plant> reservedPlants;
    private final List<Plant> availablePlants;
    public double temperature;

    public GreenhouseManagement(Path path) {
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
        try (PrintWriter writer = new PrintWriter(new FileWriter(String.valueOf(FILE_NAME)))) {
            for (Plant plant : availablePlants) {
                writer.println(plant.toString());
            }
        } catch (IOException e) {
            System.err.println("Error saving plants to file: " + e.getMessage());
        }
    }

    @Override
    public void readPlantsFromFile() {
        try (Scanner scanner = new Scanner(FILE_NAME)) {
            availablePlants.clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(DELIMITER);
                String plantType = parts[0];
                String plantName = parts[1];
                String plantDescription = parts[2];
                Plant plant = new Plant(plantName, plantType, plantDescription) {
                    @Override
                    public String getPlantType() {
                        return null;
                    }
                };
                availablePlants.add(plant);
            }
        } catch (IOException e) {
            System.err.println("Error reading plants from file: " + e.getMessage());
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
        }

        @Override
        public void waterPlants() {
            for (Plant plant : mysteryPlant) {
                System.out.println("Watering " + plant.getPlantName());
            }
        }

        @Override
        public void readPlantsFromFile() {

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

        @Override
        public void removePlant(String plantName) throws InvalidOptionException {

        }

        @Override
        public void savePlantsToFile() {

        }
    };
    public List<Plant> searchPlants(String searchTerm) {
        List<Plant> matchingPlants = new ArrayList<>();
        for (Plant plant : availablePlants) {
            if (plant.getPlantName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    plant.getPlantType().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    plant.getNativeRegion().toLowerCase().contains(searchTerm.toLowerCase())) {
                matchingPlants.add(plant);
            }
        }
        return matchingPlants;
    }
}
