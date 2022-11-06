package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class User {
    String name;
    String surname;
    String date;
    String mail;
    String password;
    double coins;
    List<MyObject> myObjects;

    public User() {}

    public User(String name, String surname, String date, String mail, String password){
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.mail = mail;
        this.password = password;
        this.coins = 50;
        this.myObjects = new LinkedList<>();
    }

    public String getPassword() {
        return this.password;
    }

    public List<MyObject> getObjects() {
        return this.myObjects;
    }

    public double getCoins() {
        return this.coins;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public void addObject(MyObject myObject) {
        this.myObjects.add(myObject);
        this.coins = this.coins - myObject.getCoins();
    }
}
