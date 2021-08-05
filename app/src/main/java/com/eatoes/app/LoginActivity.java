package com.eatoes.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String USER_ID ="userId";

    private EditText userIdET, passwordET;
    private Button loginBT;
    private String userId, password;
    private LoginCallbacks loginCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userIdET = findViewById(R.id.user_id_et);
        passwordET = findViewById(R.id.password_et);
        loginBT = findViewById(R.id.login_bt);

        loginCallbacks = new LoginCallbacks() {
            @Override
            public void onSuccess() {
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                intent.putExtra(USER_ID,userId);
                startActivity(intent);
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(LoginActivity.this,errorMessage,Toast.LENGTH_LONG).show();
            }
        };

        loginBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId = userIdET.getText().toString();
                password = passwordET.getText().toString();

                if(userId.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Please enter UserID!!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(password.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Please enter Password!!",Toast.LENGTH_LONG).show();
                    return;
                }

                LoginRepo.login(userId,password,loginCallbacks);
            }
        });

    }
}