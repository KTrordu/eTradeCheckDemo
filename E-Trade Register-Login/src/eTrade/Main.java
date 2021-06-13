package eTrade;

import java.util.ArrayList;
import eTrade.business.concretes.CheckManager;
import eTrade.business.concretes.RegisterManager;
import eTrade.core.concretes.GoogleRegisterAdapter;
import eTrade.dataAccess.concretes.HibernateUserDao;
import eTrade.entities.concretes.User;

public class Main {

    private static ArrayList<User> users = new ArrayList<User>();
    private static RegisterManager registerManager = new RegisterManager(new CheckManager(), new GoogleRegisterAdapter(), new HibernateUserDao());
    public static void main(String[] args){
        //Registers successfully
        User alptugYilmaz = new User(1,"Alptuğ","Yılmaz","2004","alptug.yilmaz@outlook.com","123456",false);
        User berfinSabahat = new User(2,"Berfin Deren","Sabahat","2004","berfinderen.sabahat@gmail.com","h5s321cva52s",true);

        registerManager.register(alptugYilmaz, users);
        System.out.println("-----------------------------------------");
        registerManager.register(berfinSabahat, users);

        System.out.println("-----------------------------------------");

        //Email and password errors
        User edwardCollins = new User(3,"Edward","Collins","1990","edward.collins","684df23g1d6saf1d",false);
        User margaretCollins = new User(4,"Margaret","Collins","1993","margaret.collins@gmail.com","pass",true);

        registerManager.register(edwardCollins, users);
        System.out.println("-----------------------------------------");
        registerManager.register(margaretCollins, users);

        System.out.println("-----------------------------------------");

        //Name errors

        User mehmetTufekci = new User(5,"Mt","Tüfekçi","1967","mehmet.tufekci@hotmail.com","3s4s6a1d345a",false);
        User hamdiSancak = new User(6,"Hamdi","Sk","1974","hamdi.sk","54wf6",true);

        registerManager.register(mehmetTufekci, users);
        System.out.println("-----------------------------------------");
        registerManager.register(hamdiSancak, users);

        System.out.println("-----------------------------------------");
    }
}
