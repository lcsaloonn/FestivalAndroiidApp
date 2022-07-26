package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.myapplication.Domain.Cart;
import com.example.myapplication.Management.CartManagement;
import com.example.myapplication.R;

import java.util.List;

public class CartAdapter extends ArrayAdapter<Cart> {
    public CartAdapter(@NonNull Context context, int resource, @NonNull List<Cart> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.item_cart, null);
        }

        ImageView ivCartPic = v.findViewById(R.id.cart_pic);
        TextView tvCartTitle = v.findViewById(R.id.cart_title);
        TextView tvCartNumberOrder = v.findViewById(R.id.cart_numberOrder);
        TextView btnCartPlus = v.findViewById(R.id.cart_plus);
        TextView btnCartMinus = v.findViewById(R.id.cart_minus);
        TextView tvCartPriceForOne = v.findViewById(R.id.cart_price_fo_one);
        TextView tvCartToTalPrice = v.findViewById(R.id.cart_total_price);

//        TextView tvTotalShop = v.findViewById(R.id.total_shop);
//        String totalShop = String.valueOf(tvTotalShop);

        final Cart[] cart = {getItem(position)};

        final int[] numberOrder = {Integer.parseInt(cart[0].getNumberOrder())};
        final double[] priceForOne = {Double.parseDouble(cart[0].getPriceForOne())};
        final double[] totalPrice = {Double.parseDouble(cart[0].getTotalPrice())};

        tvCartTitle.setText(cart[0].getTitle());
        tvCartNumberOrder.setText(cart[0].getNumberOrder());
        tvCartPriceForOne.setText(cart[0].getPriceForOne()+"€");
        tvCartToTalPrice.setText(cart[0].getTotalPrice()+"€");
        btnCartPlus.setOnClickListener(view -> {
            numberOrder[0] = numberOrder[0] + 1;
            tvCartNumberOrder.setText(String.valueOf(numberOrder[0]));

            totalPrice[0] = priceForOne[0] * numberOrder[0];
            tvCartToTalPrice.setText(String.valueOf(totalPrice[0])+"€");

//            double priceToAdd = priceForOne[0] + Double.parseDouble(totalShop);
//            tvTotalShop.setText(String.valueOf(priceToAdd)+"€");
        });
        btnCartMinus.setOnClickListener(view -> {
            if(numberOrder[0] >0){
                numberOrder[0] = numberOrder[0] - 1;
            }
            tvCartNumberOrder.setText(String.valueOf(numberOrder[0]));

            totalPrice[0] = priceForOne[0] * numberOrder[0];
            tvCartToTalPrice.setText(String.valueOf(totalPrice[0])+"€");

            //SI on l'enlève
            if(numberOrder[0] == 0){
                remove(cart[0]);
            }

//            double priceToAdd = priceForOne[0] + Double.parseDouble(totalShop);
//            tvTotalShop.setText(String.valueOf(priceToAdd)+"€");
        });

        int drawableResourceId = v.getContext().getResources().getIdentifier(cart[0].getPic(), "drawable", v.getContext().getPackageName());

        Glide.with(v.getContext())
                .load(drawableResourceId)
                .into(ivCartPic);

        return v;
    }
}
