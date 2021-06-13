package eTrade.business.concretes;

import java.util.ArrayList;

import eTrade.business.abstracts.RegisterService;
import eTrade.core.concretes.GoogleRegisterAdapter;
import eTrade.dataAccess.concretes.HibernateUserDao;
import eTrade.entities.concretes.User;

public class RegisterManager implements RegisterService{

    private CheckManager checkManager;
    private GoogleRegisterAdapter googleRegisterAdapter;
    private HibernateUserDao hibernateUserDao;

    public RegisterManager(CheckManager checkManager, GoogleRegisterAdapter googleRegisterAdapter,
            HibernateUserDao hibernateUserDao) {
        this.checkManager = checkManager;
        this.googleRegisterAdapter = googleRegisterAdapter;
        this.hibernateUserDao = hibernateUserDao;
    }

    @Override
    public void register(User user, ArrayList<User> users) {
        if(checkManager.checkUserName(user.getFirstName(), user.getLastName()) &&
           checkManager.checkPassword(user.getPassword()) &&
           checkManager.isValidEmail(user.getEmail()) &&
           checkManager.isNewEmail(user.getEmail(), users)){

            if(user.isWantsToLogInWithGoogle()){
                googleRegisterAdapter.registerToSystem(user.getFullName() + " has been registered successfully.");
                users.add(user);
            }
            else{
                hibernateUserDao.save(user, users);
            }
        }
        else{
            if(!checkManager.checkUserName(user.getFirstName(), user.getLastName())){
                System.out.println("This name is not valid.");
            }
            if(!checkManager.isValidEmail(user.getEmail())){
                System.out.println("This email is not valid.");
            }
            if(!checkManager.isNewEmail(user.getEmail(), users)){
                System.out.println("This email already exists.");
            }
            if(!checkManager.checkPassword(user.getPassword())){
                System.out.println("This password is too short.");
            }
        }
    }

    @Override
    public void login(User user, ArrayList<User> users) {
        for(User u: users){
            if(u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())){
                System.out.println("Logged in succesfully.");
                System.out.println("Welcome, " + user.getFullName());
                return;
            }
        }
        System.out.println("This email and password combination doesn't match with any account.");
    }
}
