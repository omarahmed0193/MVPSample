package com.afterapps.mvpsample.login;


public class LoginModel {

    //check credentials and login the user
    public boolean login(String username, String password) {
        return username.equalsIgnoreCase("omar") && password.equalsIgnoreCase("123456");
    }
}
