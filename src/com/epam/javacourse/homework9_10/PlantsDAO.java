package com.epam.javacourse.homework9_10;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlantsDAO {
    private final Connection conn;

    public PlantsDAO(Connection conn) {
        this.conn = conn;
    }

    public void addPlant(Plants plant) throws SQLException {
        String sql = "INSERT INTO plants (name, variety, gardener_id) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, plant.getName());
        stmt.setString(2, plant.getVariety());
        stmt.setInt(3, plant.getGardenerId());
        stmt.executeUpdate();
        System.out.println("Plant added successfully.");
        stmt.close();
    }

    public Plants getPlantById(int id) throws SQLException {
        Plants plant = null;
        String sql = "SELECT * FROM plants WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String name = rs.getString("name");
            String variety = rs.getString("variety");
            int gardenerId = rs.getInt("gardener_id");

            plant = new Plants(id, name, variety, gardenerId);
        }

        rs.close();
        stmt.close();

        return plant;
    }

    public void updatePlant(Plants plant) throws SQLException {
        String sql = "UPDATE plants SET name = ?, variety = ?, gardener_id = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, plant.getName());
        stmt.setString(2, plant.getVariety());
        stmt.setInt(3, plant.getGardenerId());
        stmt.setInt(4, plant.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<Plants> getPlantsByTypeLike(String s) throws SQLException {
        List<Plants> plants = new ArrayList<>();
        String sql = "SELECT * FROM plants WHERE variety LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + s + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String variety = rs.getString("variety");
            int gardener_id = rs.getInt("gardener_id");

            Plants plant = new Plants(id, name, variety, gardener_id);
            plants.add(plant);
        }

        rs.close();
        stmt.close();

        return plants;
    }

    public int getCount() throws SQLException {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM plants";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
        }
        rs.close();
        stmt.close();
        return count;
    }

    public Map<String, Integer> getPlantCountByGardener() throws SQLException {
        Map<String, Integer> plantCounts = new HashMap<>();
        String sql = "SELECT gardener.name, COUNT(plants.id) as num_plants " +
                "FROM gardener " +
                "LEFT JOIN plants ON gardener.id = plants.gardener_id " +
                "GROUP BY gardener.name";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String gardenerName = rs.getString("name");
            int numPlants = rs.getInt("num_plants");

            plantCounts.put(gardenerName, numPlants);
        }

        rs.close();
        stmt.close();

        return plantCounts;
    }
}
