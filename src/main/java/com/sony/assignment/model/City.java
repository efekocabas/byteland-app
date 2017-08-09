package com.sony.assignment.model;

import java.util.HashSet;
import java.util.Set;

public class City {

    private final int index;
    private final Set<City> neighbours;

    public City(int index) {
        this.index = index;
        this.neighbours = new HashSet<>();
    }

    public int getIndex() {
        return index;
    }

    public Set<City> getNeighbours() {
        return neighbours;
    }

    public int getNeighbourCount() {
        return neighbours.size();
    }

    public void addNeighbour(City city) {
        neighbours.add(city);
    }

    public void addNeighbours(Set<City> cities) {
        neighbours.addAll(cities);
    }

    public void removeNeighbour(City city) {
        neighbours.remove(city);
    }

    public void notifyNeighbours(City city) {
        for (City neighbour : neighbours) {
            neighbour.removeNeighbour(city);
            neighbour.addNeighbour(this);
        }
    }
}
