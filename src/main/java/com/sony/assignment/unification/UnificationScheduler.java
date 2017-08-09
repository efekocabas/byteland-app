package com.sony.assignment.unification;

import com.sony.assignment.exception.InputException;
import com.sony.assignment.model.Byteland;
import com.sony.assignment.model.City;
import com.sony.assignment.util.NeighbourComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnificationScheduler {

    private final Byteland byteland;

    public UnificationScheduler(Byteland byteland) {
        this.byteland = byteland;
    }

    public int calculateStepCount() {
        Map<Integer, City> cityMap = createCities(byteland);
        addNeighbours(cityMap, byteland.getRoads());

        int stepCount = 0;

        while (cityMap.size() > 1) {
            stepCount++;
            createSession(cityMap);
        }

        return stepCount;
    }

    private Map<Integer, City> createCities(Byteland byteland) {
        Map<Integer, City> cities = new HashMap<>();

        for (int i = 0; i < byteland.getCityCount(); i++) {
            cities.put(i, new City(i));
        }

        return cities;
    }

    private void addNeighbours(Map<Integer, City> cities, int[] roads) {
        for (int i = 0; i < roads.length ; i++) {
            City city = cities.get(i + 1);
            City neighbour = cities.get(roads[i]);

            if (neighbour == null) {
                throw new InputException("Road map has a city that is not in Byteland!");
            }

            city.addNeighbour(neighbour);
            neighbour.addNeighbour(city);
        }

        for (City city : cities.values()) {
            if (city.getNeighbourCount() == 0) {
                throw new InputException("Every city must have at least 1 road to another!");
            }
        }
    }

    private void createSession(Map<Integer, City> cityMap) {

        List<City> cityList = new ArrayList<>(cityMap.values());
        Collections.sort(cityList, new NeighbourComparator());

        Set<Integer> busyCities = new HashSet<>();
        Map<City, City> session = new HashMap<>();

        for (City city : cityList) {
            if (!busyCities.contains(city.getIndex())) {
                List<City> neighbourList = new ArrayList<>(city.getNeighbours());
                Collections.sort(neighbourList, new NeighbourComparator());

                for (City neighbour : neighbourList) {
                    if (!busyCities.contains(neighbour.getIndex())) {
                        busyCities.add(city.getIndex());
                        busyCities.add(neighbour.getIndex());
                        session.put(city, neighbour);
                    }
                }
            }
        }

        mergeCities(cityMap, session);
    }

    private void mergeCities(Map<Integer, City> cityMap, Map<City, City> session) {
        for (Map.Entry<City, City> attendants : session.entrySet()) {
            City city = attendants.getKey();
            City neighbour = attendants.getValue();

            neighbour.removeNeighbour(city);
            city.addNeighbours(neighbour.getNeighbours());
            city.removeNeighbour(neighbour);
            city.notifyNeighbours(neighbour);

            cityMap.remove(neighbour.getIndex());
        }
    }
}
