package com.afterapps.mvpsample.login;


import com.hannesdorfmann.mosby.mvp.MvpView;

public interface LoginView extends MvpView{
    void showLoading(boolean showLoading);

    String getUsername();

    void showUsernameErrorMessage(int emptyUsername);

    String getPassword();

    void showPasswordErrorMessage(int emptyPassword);

    void showPasswordIsShortErrorMessage(int shortPassword);

    void startMainActivity();

    void showCredentialsAreIncorrectErrorMessage(int wrongCredentials);

    void hideEditTextsErrorMessages();
}
