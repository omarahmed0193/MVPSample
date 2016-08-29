package com.afterapps.mvpsample;


import com.afterapps.mvpsample.login.LoginModel;
import com.afterapps.mvpsample.login.LoginPresenter;
import com.afterapps.mvpsample.login.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {


    @Mock
    private LoginView view;
    @Mock
    private LoginModel model;


    private LoginPresenter presenter;

    @Before
    public void initialSetup() {
        presenter = new LoginPresenter();
        presenter.attachView(view);
    }


    @Test
    public void showErrorMessageIfUsernameIsEmpty() {
        Mockito.when(view.getUsername()).thenReturn("");
        presenter.onLoginClicked();
        Mockito.verify(view).hideEditTextsErrorMessages();
        Mockito.verify(view).showUsernameErrorMessage(R.string.error_empty_username);
    }

    @Test
    public void showErrorMessageIfPasswordIsEmpty() {
        Mockito.when(view.getUsername()).thenReturn("Omar");
        Mockito.when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();
        Mockito.verify(view).showPasswordErrorMessage(R.string.error_empty_password);
    }

    @Test
    public void showErrorMessageIfPasswordIsShort() {
        Mockito.when(view.getUsername()).thenReturn("Omar");
        Mockito.when(view.getPassword()).thenReturn("12345");
        presenter.onLoginClicked();
        Mockito.verify(view).hideEditTextsErrorMessages();
        Mockito.verify(view).showPasswordIsShortErrorMessage(R.string.error_short_password);
    }

    @Test
    public void launchTheMainActivityIfCredentialsAreCorrect() {
        Mockito.when(view.getUsername()).thenReturn("Omar");
        Mockito.when(view.getPassword()).thenReturn("123456");
        presenter.onLoginClicked();
        Mockito.verify(view).hideEditTextsErrorMessages();
        Mockito.verify(view).startMainActivity();
    }

    @Test
    public void showErrorMessageIfCredentialsAreIncorrect() {
        Mockito.when(view.getUsername()).thenReturn("Omaar");
        Mockito.when(view.getPassword()).thenReturn("123457");
        presenter.onLoginClicked();
        Mockito.verify(view).hideEditTextsErrorMessages();
        Mockito.verify(view).showCredentialsAreIncorrectErrorMessage(R.string.error_wrong_credentials);
    }

}