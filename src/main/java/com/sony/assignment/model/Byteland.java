package com.sony.assignment.model;

public class Byteland {

    private final int cityCount;
    private final int[] roads;

    public Byteland(int cityCount, int[] roads) {
        this.cityCount = cityCount;
        this.roads = roads;
    }

    public int getCityCount() {
        return cityCount;
    }

    public int[] getRoads() {
        return roads;
    }
}
