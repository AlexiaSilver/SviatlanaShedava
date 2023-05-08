package com.epam.javacourse.homework9_10;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Create database connection
        Connection connection = DatabaseConnection.getConnection();

        // Add records to all the 3 table
        Plants plant = new Plants(94, "Tomato", "New York", 1);
        PlantsDAO plantsDAO = new PlantsDAO(connection);
        plantsDAO.addPlant(plant);
        GreenhouseDAO greenhouseDAO = new GreenhouseDAO(connection);
        GreenhouseDAO.addGreenhouse(102, "Greenhouse 20", "123 Main Street");
        Gardener gardener = new Gardener(126, "John Smith", 30, 1);
        GardenerDAO gardenerDAO = new GardenerDAO(connection);
        gardenerDAO.addGardener(gardener);

        // update plant name
        plant = plantsDAO.getPlantById(20);
        plant.setName("Orange");
        plant.setVariety("Valencia");
        plantsDAO.updatePlant(plant);
        System.out.println("plantID" + plant.getId() + " is updated successfully");

        // get greenhouses using between query
        System.out.println("Greenhouse using between query: ");
        try {
            List<Greenhouse> greenhouses = greenhouseDAO.getRecordsFromTableUsingBetween(1, 3);
            for (Greenhouse greenhouse : greenhouses) {
                System.out.println("ID: " + greenhouse.getId() + ", Name: " + greenhouse.getName() + ", Address: " + greenhouse.getAddress());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // get gardeners using IN query
        gardenerDAO = new GardenerDAO(connection);
        List<Gardener> gardeners = gardenerDAO.getAllGardenersByAge();
        for (Gardener g : gardeners) {
            System.out.println("List of gardeners using IN query: " + g.getName() + " is " + g.getAge() + " years old.");
        }

        // get plants using a like query
        List<Plants> plantList = plantsDAO.getPlantsByTypeLike("%oma%");
        System.out.println("List of Plants using like query: ");
        for (Plants p : plantList) {
            System.out.println("Name: " + p.getName());
            System.out.println("Variety: " + p.getVariety());
            System.out.println("Gardener ID: " + p.getGardenerId());
            System.out.println();
        }

        // get all records from all three tables using a join query
        List<JoinedRow> rows = GreenhouseDAO.getJoinedRows();
        System.out.println("All records from all three tables: ");
        for (JoinedRow row : rows) {
            System.out.println(row.getGardenerId() + ", " + row.getGardenerName() + ", " + row.getAge() + ", " + row.getGreenhouseName() + ", " + row.getPlantName() + ", " + row.getVariety());
        }

        // get the number of records in all tables
        int plantCount = plantsDAO.getCount();
        int greenhouseCount = GreenhouseDAO.getCount();
        gardenerDAO = new GardenerDAO(connection);
        int gardenerCount = gardenerDAO.getCount();
        System.out.printf("Number of records in plants table: %d\n", plantCount);
        System.out.printf("Number of records in greenhouse table: %d\n", greenhouseCount);
        System.out.printf("Number of records in gardener table: %d\n", gardenerCount);

        // delete greenhouse by id
        greenhouseDAO.deleteGreenhouse(20);
        System.out.println("Greenhouse is deleted");

        // delete all records from gardener table
        gardenerDAO = new GardenerDAO(connection);
        gardenerDAO.deleteAllGardeners();
        System.out.println("All records from Gardener are deleted");

        // get plant count by gardener using a group by query
        List<Map<String, Object>> gardenerPlantCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : plantsDAO.getPlantCountByGardener().entrySet()) {
            Map<String, Object> count = new HashMap<>();
            count.put("name", entry.getKey());
            count.put("num_plants", entry.getValue());
            gardenerPlantCounts.add(count);
        }
        System.out.println("Plant count by gardener:" + plantCount);
        for (Map<String, Object> count : gardenerPlantCounts) {
            String gardenerName = (String) count.get("name");
            plantCount = ((Number) count.get("num_plants")).intValue();
            System.out.printf("%s: %d\n", gardenerName, plantCount);
        }

        connection.close();
    }
}