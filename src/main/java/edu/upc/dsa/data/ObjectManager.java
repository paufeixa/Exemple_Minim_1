package edu.upc.dsa.data;

import edu.upc.dsa.exceptions.UserExistingException;
import edu.upc.dsa.exceptions.BuyObjectException;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Object;

import java.util.List;

public interface ObjectManager {
    public void register(String name, String surname, String date, String mail, String password) throws UserExistingException;

    public List<User> usersByAlphabet();

    public int login(String mail, String password);

    public void addObject(String objectId, String name, String description, double coins);

    public List<Object> objectsByPrice();

    public void buyObject(String mail, String objectId) throws BuyObjectException;

    public List<Object> objectsByUser(String mail);

    public int numUsers();

    public int numObjects();

    public double getUserCoins(String mail);
}
