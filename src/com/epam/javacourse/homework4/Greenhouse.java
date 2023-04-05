package com.epam.javacourse.homework4;

/**
 * This interface defines the methods that a greenhouse should implement.
 */
public interface Greenhouse {

    /**
     * Buys a plant and adds it to the greenhouse inventory.
     */
    void buyPlant(Plant plant);

    /**
     * Waters all the plants in the greenhouse.
     */
    void waterPlants();

    /**
     * Sets the temperature of the greenhouse to the given temperature in Celsius degrees.
     */
    void setTemperature(int temperature);

    /**
     * Removes the given plant from the greenhouse inventory.
     */
    void removePlant(Plant plant);
}
