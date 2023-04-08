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

    /**
     * Removes the given plant from the greenhouse inventory.
     */
    void removePlant(Plant plant);

    /**
     * Sets the temperature of the greenhouse.
     */
    void setTemperature(double temperature);

    /**
     * Receives the list of plants.
     */
    List<Plant> getPlants();

    /**
     * Creates a new Plant object with the given name, type, and native region,
     * and adds it to the greenhouse inventory.
     */
    void createPlant(String name, String type, String nativeRegion);

    /**
     * Creates a new FloweringPlant object and adds it to the greenhouse inventory.
     */
    void createPlant(FloweringPlant floweringPlant);

    /**
     * Creates a new HousePlant object and adds it to the greenhouse inventory.
     */
    void createPlant(HousePlant housePlant);

    /**
     * Creates a new Shrub object and adds it to the greenhouse inventory.
     */
    void createPlant(Shrub shrub);

    /**
     * Updates the given plant with a new name.
     */
    void updatePlant(Plant plant, String newName);
}