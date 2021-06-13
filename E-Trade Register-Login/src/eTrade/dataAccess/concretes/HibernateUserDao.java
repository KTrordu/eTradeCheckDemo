package eTrade.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.UserDao;
import eTrade.entities.concretes.User;

public class HibernateUserDao implements UserDao{

    @Override
    public void save(User user, ArrayList<User> users) {
        users.add(user);
        System.out.println(user.getFullName() + " has been added to the system.");
    }

    @Override
    public void update(User user, ArrayList<User> users) {
        users.remove(user);
        users.add(user);
        System.out.println(user.getFullName() + " has been updated.");
    }

    @Override
    public void delete(User user, ArrayList<User> users) {
        users.remove(user);
        System.out.println(user.getFullName() + " has been deleted.");
    }

    @Override
    public List<String> getAllNames(ArrayList<User> users) {
        List<String> userNames = new ArrayList<String>();

        for(User u: users){
            userNames.add(u.getFullName());
        }

        return userNames;
    }
}
