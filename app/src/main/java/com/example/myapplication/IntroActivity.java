package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.ui.login.LoginActivity;

public class IntroActivity extends AppCompatActivity {
    private Button btnStart;
   // private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btnStart=findViewById(R.id.btn_introActivity_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });

        //btnLogin=findViewById(R.id.btn_intro_login);
       // btnLogin.setOnClickListener(view -> {
        //    startActivity(new Intent(IntroActivity.this, LoginActivity.class));
       // });
    }
}