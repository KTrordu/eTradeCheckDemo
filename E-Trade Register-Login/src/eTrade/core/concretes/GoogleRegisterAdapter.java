package eTrade.core.concretes;

import Google.GoogleRegisterManager;
import eTrade.core.abstracts.GoogleRegisterService;

public class GoogleRegisterAdapter implements GoogleRegisterService{

    @Override
    public void registerToSystem(String message) {
        GoogleRegisterManager googleRegisterManager = new GoogleRegisterManager();

        googleRegisterManager.loginWithGoogle(message);
    }
}
