package eTrade.dataAccess.abstracts;

import java.util.ArrayList;
import java.util.List;

import eTrade.entities.concretes.User;

public interface UserDao {
    void save(User user, ArrayList<User> users);

    void update(User user, ArrayList<User> users);

    void delete(User user, ArrayList<User> users);

    List<String> getAllNames(ArrayList<User> users);
}
