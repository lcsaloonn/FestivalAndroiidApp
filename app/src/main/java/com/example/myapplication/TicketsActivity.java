package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.myapplication.Adapter.TicketAdapter;
import com.example.myapplication.Domain.Ticket;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TicketsActivity extends AppCompatActivity {
    private ListView lvTickets;
    private List<Ticket> ticketList;
    private TicketAdapter ticketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        initTicketList();

        lvTickets = findViewById(R.id.lv_tickets);
        ticketAdapter = new TicketAdapter(
                this,
                R.id.lv_tickets,
                ticketList);

        lvTickets.setAdapter(ticketAdapter);

        //MenuBar

        LinearLayout btnHome = findViewById(R.id.homeBtn);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(TicketsActivity.this, MainActivity.class);
            startActivity(intent);
        });

        LinearLayout btnHoodie = findViewById(R.id.hoodiesBtn);
        btnHoodie.setOnClickListener(view -> {
            Intent intent = new Intent(TicketsActivity.this, HoodieActivity.class);
            startActivity(intent);
        });

        FloatingActionButton btnCart = findViewById(R.id.card_button);
        btnCart.setOnClickListener(view -> {
            Intent intent = new Intent(TicketsActivity.this, CartActivity.class);
            startActivity(intent);
        });

        LinearLayout btnInfo = findViewById(R.id.infoBtn);
        btnInfo.setOnClickListener(view -> {
            Intent intent = new Intent(TicketsActivity.this, InfoActivity.class);
            startActivity(intent);
        });
    }

    private void initTicketList() {
        ticketList = new ArrayList<>();
        ticketList.add(new Ticket( "One Day", "12 July", 24.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "One Day", "13 July", 24.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "One Day", "14 July", 24.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "One Day", "15 July", 24.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "One Day", "16 July", 24.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Two Days", "12-13 July", 49.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Two Days", "13-14 July", 49.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Two Days", "14-15 July", 49.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Two Days", "15-16 July", 49.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Three Days", "12-13-14 July", 74.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Three Days", "13-14-15 July", 74.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Three Days", "14-15-16 July", 74.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Four Days", "12-13-14-15 July", 99.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Four Days", "13-14-15-16 July", 99.99, "icons8_ticket_100"));
        ticketList.add(new Ticket( "Entire Festival", "12-13-14-15-16 July", 124.99, "icons8_ticket_100"));

    }
}