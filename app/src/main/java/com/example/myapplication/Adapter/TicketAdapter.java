package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Domain.Ticket;
import com.example.myapplication.R;
import com.example.myapplication.ShowDetailTicketActivity;

import java.util.List;

public class TicketAdapter extends ArrayAdapter<Ticket> {
    public static final String EXTRA_TICKET = "EXTRA_TICKET";
    public TicketAdapter(@NonNull Context context, int resource, @NonNull List<Ticket> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.item_tickets, null);
        }

        TextView tvTicketType = v.findViewById(R.id.tv_hoodie_type);
        TextView tvDate = v.findViewById(R.id.hoodieDescription);
        TextView btnAdd = v.findViewById(R.id.hoodie_addBtn);
        TextView tvFee = v.findViewById(R.id.hoodie_fee);

        Ticket ticket = getItem(position);

        tvTicketType.setText(ticket.getTicketType());
        tvDate.setText(ticket.getDate());
        tvFee.setText(String.valueOf(ticket.getFee()));

        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), ShowDetailTicketActivity.class);
            intent.putExtra(EXTRA_TICKET, ticket);
            view.getContext().startActivity(intent);
        });

        return v;
    }
}
