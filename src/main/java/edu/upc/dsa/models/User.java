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
    List<Object> objects;
    public User(String name, String surname, String date, String mail, String password){
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.mail = mail;
        this.password = password;
        this.coins = 50;
        this.objects = new LinkedList<>();
    }

    public String getPassword() {
        return this.password;
    }

    public List<Object> getObjects() {
        return this.objects;
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

    public void addObject(Object object) {
        this.objects.add(object);
        this.coins = this.coins - object.getCoins();
    }
}
