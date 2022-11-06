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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMail() { return this.mail; }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCoins() { return this.coins; }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public List<MyObject> getObjects() {
        return this.myObjects;
    }

    public void setObjects(List<MyObject> myObjects) {
        this.myObjects = myObjects;
    }

    public void addObject(MyObject myObject) {
        this.myObjects.add(myObject);
        this.coins = this.coins - myObject.getCoins();
    }
}
