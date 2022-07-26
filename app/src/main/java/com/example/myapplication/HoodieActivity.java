package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.myapplication.Adapter.HoodieAdapter;
import com.example.myapplication.Domain.Hoodie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HoodieActivity extends AppCompatActivity {
    private ListView lvHoodies;
    private List<Hoodie> hoodieList;
    private HoodieAdapter hoodieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoodie);

        initHoodieList();

        lvHoodies = findViewById(R.id.lv_hoodies);
        hoodieAdapter = new HoodieAdapter(
                this,
                R.id.lv_hoodies,
                hoodieList);

        lvHoodies.setAdapter(hoodieAdapter);

        //MenuBar

        LinearLayout btnHome = findViewById(R.id.homeBtn);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(HoodieActivity.this, MainActivity.class);
            startActivity(intent);
        });

        LinearLayout btnTickets = findViewById(R.id.ticketsBtn);
        btnTickets.setOnClickListener(view -> {
            Intent intent = new Intent(HoodieActivity.this, TicketsActivity.class);
            startActivity(intent);
        });

        FloatingActionButton btnCart = findViewById(R.id.card_button);
        btnCart.setOnClickListener(view -> {
            Intent intent = new Intent(HoodieActivity.this, CartActivity.class);
            startActivity(intent);
        });

        LinearLayout btnInfo = findViewById(R.id.infoBtn);
        btnInfo.setOnClickListener(view -> {
            Intent intent = new Intent(HoodieActivity.this, InfoActivity.class);
            startActivity(intent);
        });

    }

    private void initHoodieList() {
        hoodieList = new ArrayList<>();
        hoodieList.add(new Hoodie( "Hoodie", "Official Hoodie of HELHa Music Festival", 35.99, "hoodie"));
        hoodieList.add(new Hoodie( "T-Shirt", "Official T-Shirt of HELHa Music Festival", 19.99, "tshirt"));
    }
}