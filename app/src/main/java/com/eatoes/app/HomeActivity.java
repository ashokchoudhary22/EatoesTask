package com.eatoes.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView welcomeMessageTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcomeMessageTV = findViewById(R.id.welcome_message_tv);

        String userId = getIntent().getStringExtra(LoginActivity.USER_ID);

        welcomeMessageTV.setText("Hello!! - "+ userId);
    }
}