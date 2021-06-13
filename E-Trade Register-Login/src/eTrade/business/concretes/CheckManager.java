package eTrade.business.concretes;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTrade.business.abstracts.CheckService;
import eTrade.entities.concretes.User;

public class CheckManager implements CheckService{

    @Override
    public boolean checkPassword(String password) {
        if(password.length() >= 6){
            return true;
        }
        return false;
    }

    @Override
    public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public boolean isNewEmail(String email, ArrayList<User> users) {
        for(User u: users){
            if(u.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkUserName(String firstName, String lastName) {
        if(firstName.length() > 2 && lastName.length() > 2){
            return true;
        }
        return false;
    }

}
