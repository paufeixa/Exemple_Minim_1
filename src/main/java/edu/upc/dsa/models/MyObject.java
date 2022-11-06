package edu.upc.dsa.models;

public class MyObject {
    String objectId;
    String name;
    String description;
    double coins;

    public MyObject(String objectId, String name, String description, double coins) {
        this.objectId = objectId;
        this.name = name;
        this.description = description;
        this.coins = coins;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getCoins() {
        return this.coins;
    }
}
