package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Adapter.TicketAdapter;
import com.example.myapplication.Domain.Ticket;

public class ShowDetailTicketActivity extends AppCompatActivity {

    public static final String EXTRA_CART_TICKET = "EXTRA_CART_TICKET";
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt;
    private ImageView ticketPic;
    private Button plusBtn, minusBtn;
    private Ticket object;
    private int numberOrder = 1;

    private CartActivity cartActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_ticket);

        initView();
        getBundle();
    }

    private void getBundle() {
        final Ticket object = getIntent().getParcelableExtra(TicketAdapter.EXTRA_TICKET);

        int drawableResourceId = this.getResources().getIdentifier(object.getTicketPic(), "drawable", this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(ticketPic);

        titleTxt.setText(object.getTicketType());
        feeTxt.setText(object.getFee()+"€");
        descriptionTxt.setText(object.getDate());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(view -> {
            numberOrder = numberOrder + 1;
            numberOrderTxt.setText(String.valueOf(numberOrder));
        });
        minusBtn.setOnClickListener(view -> {
            if(numberOrder>1){
                numberOrder = numberOrder - 1;
            }
            numberOrderTxt.setText(String.valueOf(numberOrder));
        });
        addToCartBtn.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), CartActivity.class);
            intent.putExtra(EXTRA_CART_TICKET, object);
            intent.putExtra("numberOrder", numberOrder);
            view.getContext().startActivity(intent);
        });
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.btn_detail_ticket_addToCart);
        titleTxt = findViewById(R.id.tv_ticket_title_txt);
        feeTxt = findViewById(R.id.tv_price_text);
        descriptionTxt = findViewById(R.id.detail_ticket_description);
        numberOrderTxt = findViewById(R.id.tv_detail_ticket_numberOrder);
        ticketPic = findViewById(R.id.iv_detail_ticket_pic);
        plusBtn = findViewById(R.id.btn_detail_ticket_plus);
        minusBtn = findViewById(R.id.btn_detail_ticket_minus);
    }
}