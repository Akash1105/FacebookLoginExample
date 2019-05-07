package com.example.facebookloginexample;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    LoginButton loginFb;
    TextView tv;
    CallbackManager cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginFb = (LoginButton)findViewById(R.id.fb_button);
        tv = findViewById(R.id.textView);
        cb = CallbackManager.Factory.create();
        loginFb.registerCallback(cb, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                tv.setText("Login Sucess \n" + loginResult.getAccessToken().getUserId()+
                        "\n" +loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
            tv.setText("Failed !");

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        cb.onActivityResult(requestCode,resultCode,data);
    }
}
