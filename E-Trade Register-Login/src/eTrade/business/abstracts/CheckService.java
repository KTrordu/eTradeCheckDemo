package eTrade.business.abstracts;

import java.util.ArrayList;

import eTrade.entities.concretes.User;

public interface CheckService {
    boolean checkPassword(String password);

    boolean isValidEmail(String email);

    boolean isNewEmail(String email, ArrayList<User> users);

    boolean checkUserName(String firstName, String lastName);
}
