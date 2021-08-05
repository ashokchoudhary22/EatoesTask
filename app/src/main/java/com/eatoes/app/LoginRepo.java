package com.eatoes.app;

public class LoginRepo {

    public static void login(String userId, String password, LoginCallbacks loginCallbacks){
        //we can call api here & then we can call callbacks

        loginCallbacks.onSuccess();
        //loginCallbacks.onFailure("Wrong Password!!");
    }

}
