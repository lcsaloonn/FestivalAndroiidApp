package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Domain.Artist;
import com.example.myapplication.Domain.ArtistAdmin;
import com.example.myapplication.R;

import java.util.List;

public class ArtistAdminAdapter extends ArrayAdapter<ArtistAdmin> {
    public ArtistAdminAdapter(@NonNull Context context, int resource, @NonNull List<ArtistAdmin> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.item_admin, null);
        }

        TextView tvName = v.findViewById(R.id.tv_name);

        ArtistAdmin artistAdmin = getItem(position);

        tvName.setText(artistAdmin.getName());

        return v;
    }
}
