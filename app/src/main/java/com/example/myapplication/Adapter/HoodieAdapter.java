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

import com.example.myapplication.Domain.Hoodie;
import com.example.myapplication.R;
import com.example.myapplication.ShowDetailHoodieActivity;

import java.util.List;

public class HoodieAdapter extends ArrayAdapter<Hoodie> {
    public static final String EXTRA_HOODIE = "EXTRA_HOODIE";
    public HoodieAdapter(@NonNull Context context, int resource, @NonNull List<Hoodie> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.item_hoodie, null);
        }

        ImageView ivHoodiePic = v.findViewById(R.id.picHoodie);
        TextView tvHoodieType = v.findViewById(R.id.tv_hoodie_type);
        TextView tvDescription = v.findViewById(R.id.hoodieDescription);
        TextView btnAdd = v.findViewById(R.id.hoodie_addBtn);
        TextView tvFee = v.findViewById(R.id.hoodie_fee);

        Hoodie hoodie = getItem(position);

        tvHoodieType.setText(hoodie.getHoodieType());
        tvDescription.setText(hoodie.getDescription());
        tvFee.setText(String.valueOf(hoodie.getFee()));
        switch (position){
            case 0:{
                ivHoodiePic.setImageResource(R.drawable.hoodie);

                break;
            }
            case 1:{
                ivHoodiePic.setImageResource(R.drawable.tshirt);
            }
        }

        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ShowDetailHoodieActivity.class);
            intent.putExtra(EXTRA_HOODIE, hoodie);
            view.getContext().startActivity(intent);
        });

        return v;
    }
}
