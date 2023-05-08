package com.epam.javacourse.homework9_10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GreenhouseDAO {
    private static Connection conn;

    public GreenhouseDAO(Connection conn) {
        GreenhouseDAO.conn = conn;
    }

    public static void addGreenhouse(Integer id, String name, String address) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO greenhouse(id, name, address) VALUES (?, ?, ?)")) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, address);
            stmt.executeUpdate();
            System.out.println("Greenhouse added successfully.");
        }
    }

    public void deleteGreenhouse(int id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM greenhouse WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Greenhouse> getRecordsFromTableUsingBetween(int lowerId, int upperId) throws SQLException {
        List<Greenhouse> greenhouses = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM greenhouse WHERE id BETWEEN ? AND ?")) {
            stmt.setInt(1, lowerId);
            stmt.setInt(2, upperId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Greenhouse greenhouse = new Greenhouse(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
                greenhouses.add(greenhouse);
            }
        }
        return greenhouses;
    }

    public static List<JoinedRow> getJoinedRows() throws SQLException {
        List<JoinedRow> result = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(
                "SELECT g.id AS gardener_id, g.name AS gardener_name, g.age, gr.name AS greenhouse_name, p.name AS plant_name, p.variety " +
                        "FROM gardener g " +
                        "LEFT JOIN greenhouse gr ON g.greenhouse_id = gr.id " +
                        "LEFT JOIN plants p ON gr.id = p.greenhouse_id " +
                        "ORDER BY g.name")) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int gardenerId = rs.getInt("gardener_id");
                    String gardenerName = rs.getString("gardener_name");
                    int age = rs.getInt("age");
                    String greenhouseName = rs.getString("greenhouse_name");
                    String plantName = rs.getString("plant_name");
                    String variety = rs.getString("variety");
                    JoinedRow row = new JoinedRow(gardenerId, gardenerName, age, greenhouseName, plantName, variety);
                    result.add(row);
                }
            }
        }
        return result;
    }

    public static int getCount() throws SQLException {
        String sql = "SELECT COUNT(*) FROM greenhouse";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        rs.close();
        stmt.close();
        return count;
    }
}
