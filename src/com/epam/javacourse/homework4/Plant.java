package com.epam.javacourse.homework4;

/**
 * An interface representing a plant that can be stored in a greenhouse.
 */
public interface Plant {

    /**
     * Creates a new plant with the specified name, type, and native region.
     */
    void createPlant(String name, String type, String nativeRegion);

    /**
     * Updates the information for an existing plant with the specified name, type, and native region.
     */
    void updatePlant(String name, String type, String nativeRegion);

    /**
     * Removes the plant with the specified name from the greenhouse.
     */
    default void removePlant(String name) {

        System.out.println(name + " is removed from Greenhouse.");
    }

    /**
     * Returns the type of the plant.
     */
    String getPlantType();

    /**
     * Returns the native region of the plant.
     */
    String getNativeRegion();

    /**
     * Returns the name of the plant.
     */
    String getPlantName();

}