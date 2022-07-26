package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Adapter.CartAdapter;
import com.example.myapplication.Adapter.HoodieAdapter;
import com.example.myapplication.Domain.Cart;
import com.example.myapplication.Domain.Hoodie;
import com.example.myapplication.Domain.Ticket;
import com.example.myapplication.Management.CartManagement;

import java.util.ArrayList;
import java.util.List;

interface ICartManagement{
    CartManagement cartManagement = new CartManagement();
}


public class CartActivity extends AppCompatActivity {
    private ListView lvCartHoodies;
    private ListView lvCartTickets;
    private CartManagement cartManagement;
    private CartAdapter cartAdapter;

    private TextView tvTotalShop;

    private String cartPic, cartTitle, cartNumberOrder, cartPriceForOne, cartTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tvTotalShop = findViewById(R.id.total_shop);
        lvCartHoodies = findViewById(R.id.lv_cart_hoodies);
        lvCartTickets = findViewById(R.id.lv_cart_tickets);
        cartManagement = ICartManagement.cartManagement;

        initCartHoodieList();
        initCartTicketList();
        getBundle();
        CalculateTotalPrice();

        //MenuBar

        LinearLayout btnHome = findViewById(R.id.homeBtn);
        btnHome.setOnClickListener(view -> {
            Intent intent = new Intent(CartActivity.this, MainActivity.class);
            startActivity(intent);
        });

        LinearLayout btnTickets = findViewById(R.id.ticketsBtn);
        btnTickets.setOnClickListener(view -> {
            Intent intent = new Intent(CartActivity.this, TicketsActivity.class);
            startActivity(intent);
        });

        LinearLayout btnHoodies = findViewById(R.id.hoodiesBtn);
        btnHoodies.setOnClickListener(view -> {
            Intent intent = new Intent(CartActivity.this, HoodieActivity.class);
            startActivity(intent);
        });

        LinearLayout btnInfo = findViewById(R.id.infoBtn);
        btnInfo.setOnClickListener(view -> {
            Intent intent = new Intent(CartActivity.this, InfoActivity.class);
            startActivity(intent);
        });

    }

    private void CalculateTotalPrice() {
        tvTotalShop = findViewById(R.id.total_shop);
        double total = 0;
        for(int i=0; i<cartManagement.cartHoodieList.size();i++){
            total=total + Double.parseDouble(cartManagement.cartHoodieList.get(i).getTotalPrice());
        }
        for(int i=0; i<cartManagement.cartTicketList.size();i++){
            total=total + Double.parseDouble(cartManagement.cartTicketList.get(i).getTotalPrice());
        }
        tvTotalShop.setText(String.valueOf(total));

    }


    public void getBundle() {
        if (getIntent().hasExtra(ShowDetailHoodieActivity.EXTRA_CART_HOODIE)) {
            final Hoodie hoodie = getIntent().getParcelableExtra(ShowDetailHoodieActivity.EXTRA_CART_HOODIE);
            final int numberOrder = getIntent().getIntExtra("numberOrder", 1);

            cartPic = hoodie.getHoodiePic();
            cartTitle = hoodie.getHoodieType();
            cartNumberOrder = String.valueOf(numberOrder);
            cartPriceForOne = String.valueOf(hoodie.getFee());
            cartTotalPrice = String.valueOf(hoodie.getFee() * numberOrder);
            cartManagement.cartHoodieList.add(new Cart(cartPic, cartTitle, cartNumberOrder, cartPriceForOne, cartTotalPrice));
            initCartHoodieList();
        }
        else if(getIntent().hasExtra(ShowDetailTicketActivity.EXTRA_CART_TICKET)){
            final Ticket ticket = getIntent().getParcelableExtra(ShowDetailTicketActivity.EXTRA_CART_TICKET);
            final int numberOrder = getIntent().getIntExtra("numberOrder", 1);

            cartPic = ticket.getTicketPic();
            cartTitle = ticket.getTicketType();
            cartNumberOrder = String.valueOf(numberOrder);
            cartPriceForOne = String.valueOf(ticket.getFee());
            cartTotalPrice = String.valueOf(ticket.getFee() * numberOrder);
            cartManagement.cartTicketList.add(new Cart(cartPic, cartTitle, cartNumberOrder, cartPriceForOne, cartTotalPrice));
            initCartTicketList();
        }

    }

    private void initCartHoodieList() {

        cartAdapter = new CartAdapter(
                this,
                R.id.lv_cart_hoodies,
                cartManagement.cartHoodieList);

        lvCartHoodies.setAdapter(cartAdapter);
    }

    private void initCartTicketList() {
        cartAdapter = new CartAdapter(
                this,
                R.id.lv_cart_tickets,
                cartManagement.cartTicketList);

        lvCartTickets.setAdapter(cartAdapter);
    }
}