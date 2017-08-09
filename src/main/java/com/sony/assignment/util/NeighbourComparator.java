package com.sony.assignment.util;

import com.sony.assignment.model.City;

import java.util.Comparator;

public class NeighbourComparator implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return Integer.valueOf(o1.getNeighbourCount()).compareTo(
                o2.getNeighbourCount());
    }
}
