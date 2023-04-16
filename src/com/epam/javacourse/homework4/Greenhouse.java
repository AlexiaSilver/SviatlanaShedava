package com.epam.javacourse.homework4;

import java.util.List;

/**
 * This interface defines the methods that a greenhouse should implement.
 */
public interface Greenhouse {

    /**
     * Buys a plant and adds it to the greenhouse inventory.
     */
    void buyPlant(String name);

    /**
     * Waters all the plants in the greenhouse.
     */
    void waterPlants();

    void readPlantsFromFile();

    /**
     * Receives the list of plants.
     */
    List<Plant> getPlants();

    /**
     * Creates a new Plant object with the given name, type, and native region,
     * and adds it to the greenhouse inventory.
     */
    void addPlant(Plant plant);

    /**
     * Updates the given plant with a new name.
     */
    void updatePlant(Plant plant, String newName);

    /**
     * Removes the given plant from the greenhouse inventory.
     */
    void removePlant(String plantName) throws InvalidOptionException;

    /**
     * Saves plants to file
     */
    void savePlantsToFile();


}
