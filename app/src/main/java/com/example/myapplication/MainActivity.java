package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Adapter.CategoryAdapter;
import com.example.myapplication.Adapter.LineUpAdapter;
import com.example.myapplication.Domain.CategoryDomain;
import com.example.myapplication.Domain.LineUpDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterCategory;
private RecyclerView recyclerViewCategoryList;
private RecyclerView.Adapter adapterLineUp;
private RecyclerView recyclerViewLineUpList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewLineUp();

        TextView btnParticipate = findViewById(R.id.btn_mainActivity_participate);
        btnParticipate.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TicketsActivity.class);
            startActivity(intent);
        });

        //MenuBar

        LinearLayout btnTickets = findViewById(R.id.ticketsBtn);
        btnTickets.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TicketsActivity.class);
            startActivity(intent);
        });

        LinearLayout btnHoodies = findViewById(R.id.hoodiesBtn);
        btnHoodies.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HoodieActivity.class);
            startActivity(intent);
        });

        FloatingActionButton btnCart = findViewById(R.id.card_button);
        btnCart.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });

        LinearLayout btnInfo = findViewById(R.id.infoBtn);
        btnInfo.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(intent);
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Ticket", "icons8_ticket_100"));
        categoryList.add(new CategoryDomain("Line-up", "icons8_micro_100"));
        categoryList.add(new CategoryDomain("Hoodies", "icons8_jumper_100"));
        categoryList.add(new CategoryDomain("Info", "icons8_info_100"));
        categoryList.add(new CategoryDomain("Settings", "icons8_services_100"));

        adapterCategory = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapterCategory);

    }

    private void recyclerViewLineUp() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewLineUpList = findViewById(R.id.recyclerView2);
        recyclerViewLineUpList.setLayoutManager(linearLayoutManager);

        ArrayList<LineUpDomain> lineUpList = new ArrayList<>();
        lineUpList.add(new LineUpDomain("Angele", "angele"));
        lineUpList.add(new LineUpDomain("Aya Nakamura", "aya"));
        lineUpList.add(new LineUpDomain("Bigflo et Oli", "beo"));
        lineUpList.add(new LineUpDomain("More", "icons8_view_more_96"));

        adapterLineUp = new LineUpAdapter(lineUpList);
        recyclerViewLineUpList.setAdapter(adapterLineUp);


    }
}