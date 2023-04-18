package com.epam.javacourse.homework4;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidChoiceException, IllegalStateException {
        Path path = Path.of("src/com/epam/javacourse/resources/plants.txt");
        GreenhouseManagement greenhouse = new GreenhouseManagement(path);
        Greenhouse mysteryGreenhouse = greenhouse.greenhouse;
        List<Plant> mysteryPlants = mysteryGreenhouse.getPlants();
        for (Plant plant : mysteryPlants) {
            System.out.println("Mystery plant: " + plant.getPlantName());
        }
        Scanner scanner = new Scanner(System.in);
        GreenhouseManagement.TemperatureSensor sensor = new GreenhouseManagement.TemperatureSensor(25.0);
        double currentTemperature = sensor.getTemperature();
        System.out.println("Current temperature: " + currentTemperature + " degrees Celsius");
        Plant.useGardenTool(greenhouse, "Watering can");

        boolean exit = false;
        do {
            System.out.println("Enter 1 Add a new plant to the greenhouse, 2 Remove a plant from the greenhouse, 3 Find a plant in the greenhouse by any parameter, 4 Quit:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the name of the plant:");
                    String name = scanner.nextLine();

                    System.out.println("Enter the type of the plant (Flowering Plant, House Plant, or Shrub):");
                    String type = scanner.nextLine();

                    System.out.println("Enter the native region of the plant:");
                    String nativeRegion = scanner.nextLine();

                    switch (type) {
                        case "Flowering Plant" -> {
                            System.out.println("Please enter the flowering time (in days):");
                            int floweringTime = scanner.nextInt();
                            FloweringPlant newPlant = new FloweringPlant(name, type, nativeRegion, floweringTime);
                            greenhouse.addPlant(newPlant);
                            System.out.println("New flowering plant added successfully.");
                        }
                        case "House Plant" -> {
                            System.out.println("Does the plant need sunlight? (true/false):");
                            boolean needsSunlight = scanner.nextBoolean();
                            scanner.nextLine();
                            HousePlant newPlant = new HousePlant(name, type, nativeRegion, needsSunlight);
                            greenhouse.addPlant(newPlant);
                            System.out.println("New house plant added successfully.");
                        }
                        case "Shrub" -> {
                            System.out.println("Please enter the height (in cm):");
                            int height = scanner.nextInt();
                            scanner.nextLine();
                            Shrub newPlant = new Shrub(name, type, nativeRegion, height);
                            greenhouse.addPlant(newPlant);
                            System.out.println("New shrub added successfully.");
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + type);
                    }
                    greenhouse.savePlantsToFile();
                }
                case 2 -> {
                    System.out.println("Enter the name of the plant to remove:");
                    String plant = scanner.nextLine();
                    try {
                        greenhouse.removePlant(plant);
                        System.out.println("Plant removed successfully.");
                    } catch (InvalidOptionException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Enter the search term (name, type or region):");
                    String search = scanner.nextLine();
                    List<Plant> result = greenhouse.searchPlants(search);
                    if (result.isEmpty()) {
                        System.out.println("No matching plants found.");
                    } else {
                        System.out.println("Matching plants:");
                        for (Plant plant : result) {
                            System.out.println(plant);
                        }
                    }
                }
                case 4 -> {
                    exit = true;
                    System.out.println("Exiting the program...");
                }
                default -> throw new InvalidChoiceException("Invalid choice.");
            }
        } while (!exit);
        scanner.close();
    }
}
