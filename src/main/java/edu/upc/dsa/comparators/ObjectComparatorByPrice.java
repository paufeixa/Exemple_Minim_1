package edu.upc.dsa.comparators;

import edu.upc.dsa.models.Object;

import java.util.Comparator;

public class ObjectComparatorByPrice implements Comparator<Object> {
    public int compare(Object object1, Object object2) {
        return (int) ((object2.getCoins() - object1.getCoins()) * 1000);
    }
}
