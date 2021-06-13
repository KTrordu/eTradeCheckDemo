package eTrade.business.abstracts;

import java.util.ArrayList;

import eTrade.entities.concretes.User;

public interface RegisterService {
    void register(User user, ArrayList<User> users);

    void login(User user, ArrayList<User> users);
}
