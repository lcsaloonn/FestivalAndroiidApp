package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.TicketAdapter;
import com.example.myapplication.Domain.Ticket;
import com.example.myapplication.Domain.TicketApi;
import com.example.myapplication.data.Result;
import com.example.myapplication.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TicketsActivity extends AppCompatActivity {
    private ListView lvTickets;
    private List<Ticket> ticketList;
    private TicketAdapter ticketAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
       // initTicketList();
         getAllTickets();

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
/**
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
**/
    private void getAllTickets(){

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://webapp-220801095131.azurewebsites.net/api/Ticket",
                            new Response.Listener<String>() {
                        @Override
                        public void onResponse(String  response) {
                            jsonToJava(response);
                            Log.d("res", response);


                            if (response.equals("success")) {
                                Intent intent = new Intent(TicketsActivity.this, Result.Success.class);
                                startActivity(intent);
                                finish();

                            } else if (response.equals("failure")) {
                                Toast.makeText(TicketsActivity.this, "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(TicketsActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                            System.out.println(error.toString());
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();

                            return data;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);


    }
    public void jsonToJava(String response){
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<TicketApi>>(){}.getType();
        ArrayList<TicketApi> userArray = gson.fromJson(response, userListType);
        createTiketList(userArray);
    }

    public void createTiketList(ArrayList<TicketApi> list){
        ticketList = new ArrayList<>();
        for(TicketApi ticket : list) {
            System.out.println(ticket);
            String date=DetermineDate(ticket.getNom());
            Double price =DeterminePrice(ticket.getNom());
            ticketList.add(new Ticket( ticket.getNom() , date, price, "icons8_ticket_100"));
        }
        lvTickets = findViewById(R.id.lv_tickets);
        ticketAdapter = new TicketAdapter(
                this,
                R.id.lv_tickets,
                ticketList);

        lvTickets.setAdapter(ticketAdapter);
    }

    public String DetermineDate(String date){
        if(date.equals("Pass 3 jours")){
            return "12 au 14 Juillet";
        }else if(date.equals("Pass 2 jours")){
            return "12-13/13-14/12-14 juillet";
        }else{
            return "12-13-14 juillet";
        }

    }

    public double DeterminePrice(String date){
        if(date.equals("Pass 3 jours")){
            return 69.99;
        }else if(date.equals("Pass 2 jours")){
            return 39.99;
        }else{
            return 24.99;
        }

    }


}