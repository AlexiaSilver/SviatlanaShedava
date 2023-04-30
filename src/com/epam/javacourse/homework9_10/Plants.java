package com.epam.javacourse.homework9_10;

public class Plants {
    private final int id;
    private String name;
    private String variety;
    private final int gardener_id;

    public Plants(int id, String name, String variety, int gardener_id) {
        this.id = id;
        this.name = name;
        this.variety = variety;
        this.gardener_id = gardener_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVariety() {
        return variety;
    }

    public int getGardenerId() {
        return gardener_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
