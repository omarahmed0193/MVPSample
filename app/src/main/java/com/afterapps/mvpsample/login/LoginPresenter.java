package com.afterapps.mvpsample.login;

import com.afterapps.mvpsample.R;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;


public class LoginPresenter extends MvpBasePresenter<LoginView> {

    LoginModel mLoginModel;

    public LoginPresenter() {
        mLoginModel = new LoginModel();
    }

    public void onLoginClicked() {
        if (isViewAttached()) {
            getView().hideEditTextsErrorMessages();
            if (getView().getUsername().isEmpty()) {
                getView().showUsernameErrorMessage(R.string.error_empty_username);
            } else if (getView().getPassword().isEmpty()) {
                getView().showPasswordErrorMessage(R.string.error_empty_password);
            } else if (getView().getPassword().length() < 6) {
                getView().showPasswordIsShortErrorMessage(R.string.error_short_password);
            } else {
                if (mLoginModel.login(getView().getUsername(), getView().getPassword())) {
                    getView().startMainActivity();
                } else {
                    getView().showCredentialsAreIncorrectErrorMessage(R.string.error_wrong_credentials);
                }
            }
        }
    }


}
