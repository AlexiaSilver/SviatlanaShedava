package com.epam.javacourse.homework9_10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GardenerDAO {

    private final Connection conn;

    public GardenerDAO(Connection conn) {
        this.conn = conn;
    }

    public int getCount() throws SQLException {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM gardener";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        }
        return count;
    }

    public void addGardener(Gardener gardener) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO gardener (id, name, age, greenhouse_id) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gardener.getId());
            pstmt.setString(2, gardener.getName());
            pstmt.setInt(3, gardener.getAge());
            pstmt.setInt(4, gardener.getGreenhouseId());

            pstmt.executeUpdate();
            System.out.println("Gardener added successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Gardener> getAllGardenersByAge() throws SQLException {
        List<Gardener> gardeners = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM gardener WHERE age IN (30, 35, 40)")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Gardener gardener = new Gardener(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getInt("greenhouse_id"));
                gardeners.add(gardener);
            }
        }
        return gardeners;
    }

    public void deleteAllGardeners() throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM gardener")) {
            stmt.executeUpdate();
        }
    }
}
