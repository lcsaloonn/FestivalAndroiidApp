package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InfoActivity extends AppCompatActivity {
    private TextView btnGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btnGoogleMap=findViewById(R.id.btn_GoogleMap);
        btnGoogleMap.setOnClickListener(view -> {
            Uri gmmIntentUri = Uri.parse("google.streetview:cbll=50.4519254,3.9852703");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        //MenuBar

        LinearLayout btnHome = findViewById(R.id.homeBtn);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(InfoActivity.this, MainActivity.class);
            startActivity(intent);
        });

        LinearLayout btnTickets = findViewById(R.id.ticketsBtn);
        btnTickets.setOnClickListener(view -> {
            Intent intent = new Intent(InfoActivity.this, TicketsActivity.class);
            startActivity(intent);
        });

        FloatingActionButton btnCart = findViewById(R.id.card_button);
        btnCart.setOnClickListener(view -> {
            Intent intent = new Intent(InfoActivity.this, CartActivity.class);
            startActivity(intent);
        });

        LinearLayout btnHoodie = findViewById(R.id.hoodiesBtn);
        btnHoodie.setOnClickListener(view -> {
            Intent intent = new Intent(InfoActivity.this, HoodieActivity.class);
            startActivity(intent);
        });
    }
}