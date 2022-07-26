package com.example.myapplication.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Domain.LineUpDomain;
import com.example.myapplication.LineUpActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class LineUpAdapter extends RecyclerView.Adapter<LineUpAdapter.ViewHolder> {
    ArrayList<LineUpDomain> LineUpDomains;

    public LineUpAdapter(ArrayList<LineUpDomain> LineUpDomains) {
        this.LineUpDomains = LineUpDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_lineup, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lineUpName.setText(LineUpDomains.get(position).getName());
        String picUrl="";
        switch (position){
            case 0:{
                picUrl="angele";
                break;
            }
            case 1:{
                picUrl="aya";
                break;
            }
            case 2:{
                picUrl="beo";
                break;
            }
            case 3:{
                picUrl="icons8_view_more_96";
                break;
            }
        }
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.artist_background));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.lineUpPic);

        holder.mainLayout.setOnClickListener(view -> {
            if(holder.getAdapterPosition()==3){
                Intent intent = new Intent(holder.itemView.getContext(), LineUpActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return LineUpDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView lineUpName;
        ImageView lineUpPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lineUpName=itemView.findViewById(R.id.lineUpName);
            lineUpPic=itemView.findViewById(R.id.lineUpPic);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
