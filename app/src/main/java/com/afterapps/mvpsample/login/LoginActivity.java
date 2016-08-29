package com.afterapps.mvpsample.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.afterapps.mvpsample.R;
import com.afterapps.mvpsample.main.MainActivity;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends MvpActivity<LoginView, LoginPresenter>
        implements LoginView {

    //declaring UI views
    @BindView(R.id.username_edit_text) EditText mUsernameEditText;
    @BindView(R.id.username_text_input_layout) TextInputLayout mUsernameTextInputLayout;
    @BindView(R.id.password_edit_text) EditText mPasswordEditText;
    @BindView(R.id.password_text_input_layout) TextInputLayout mPasswordTextInputLayout;
    @BindView(R.id.login_button) Button mLoginButton;
    @BindView(R.id.progress_bar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //wire up butterknife
        ButterKnife.bind(this);

        //retain the presenter instance
        setRetainInstance(true);


        //define login button click listener
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLoginClicked();
            }
        });
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void showLoading(boolean showLoading) {
        if (showLoading) {
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public String getUsername() {
        return mUsernameEditText.getText().toString();
    }

    @Override
    public void showUsernameErrorMessage(int emptyUsername) {
        mUsernameTextInputLayout.setError(getString(emptyUsername));
    }

    @Override
    public String getPassword() {
        return mPasswordEditText.getText().toString();
    }

    @Override
    public void showPasswordErrorMessage(int emptyPassword) {
        mPasswordTextInputLayout.setError(getString(emptyPassword));
    }

    @Override
    public void showPasswordIsShortErrorMessage(int shortPassword) {
        mPasswordTextInputLayout.setError(getString(shortPassword));
    }

    @Override
    public void startMainActivity() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showCredentialsAreIncorrectErrorMessage(int wrongCredentials) {
        Toast.makeText(this, wrongCredentials, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideEditTextsErrorMessages() {
        //clear the TextInputLayout error messages
        mUsernameTextInputLayout.setError(null);
        mPasswordTextInputLayout.setError(null);
    }
}
