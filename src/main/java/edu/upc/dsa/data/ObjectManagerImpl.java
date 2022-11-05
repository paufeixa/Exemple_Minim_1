package edu.upc.dsa.data;

import edu.upc.dsa.comparators.ObjectComparatorByPrice;
import edu.upc.dsa.comparators.UserComparatorByAlphabet;
import edu.upc.dsa.exceptions.UserExistingException;
import edu.upc.dsa.exceptions.BuyObjectException;
import edu.upc.dsa.models.Object;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObjectManagerImpl implements ObjectManager {
    private static ObjectManager instance;
    final static Logger logger = Logger.getLogger(ObjectManagerImpl.class);
    HashMap<String, User> users;
    HashMap<String, Object> objects;

    public ObjectManagerImpl() {
        users = new HashMap<>();
        objects = new HashMap<>();
    }

    @Override
    public void register(String name, String surname, String date, String mail, String password) throws UserExistingException{
        if (users.containsKey(mail)) {
            throw new UserExistingException();
        }
        User newUser = new User(name, surname, date, mail, password);
        users.put(mail, newUser);
    }

    @Override
    public List<User> usersByAlphabet() {
        List<User> usersByAlphabet = new ArrayList<>(users.values());
        usersByAlphabet.sort(new UserComparatorByAlphabet());
        return usersByAlphabet;
    }

    @Override
    public int login(String mail, String password) {
        if (users.containsKey(mail)) {
            User user = users.get(mail);
            if (user.getPassword().equals(password)) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public void addObject(String objectId, String name, String description, double coins) {
        Object newObject = new Object(objectId, name, description, coins);
        objects.put(objectId, newObject);
    }

    @Override
    public List<Object> objectsByPrice() {
        List<Object> objectsByPrice = new ArrayList<>(objects.values());
        objectsByPrice.sort(new ObjectComparatorByPrice());
        return objectsByPrice;
    }

    @Override
    public void buyObject(String mail, String objectId) throws BuyObjectException {
        if (!users.containsKey(mail) || !objects.containsKey(objectId)) {
            throw new BuyObjectException();
        }
        User user = users.get(mail);
        Object object = objects.get(objectId);
        if (user.getCoins() < object.getCoins()) {
            throw new BuyObjectException();
        }
        user.addObject(object);
    }

    @Override
    public List<Object> objectsByUser(String mail) {
        return users.get(mail).getObjects();
    }

    @Override
    public int numUsers() {
        return users.size();
    }

    @Override
    public int numObjects() {
        return objects.size();
    }

    @Override
    public double getUserCoins(String mail) {
        return users.get(mail).getCoins();
    }

    public static ObjectManager getInstance() {
        if (instance==null) {
            instance = new ObjectManagerImpl();
        }
        return instance;
    }
}
