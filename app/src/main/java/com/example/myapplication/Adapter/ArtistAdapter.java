package com.example.myapplication.Adapter;

import android.app.Activity;
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
import com.example.myapplication.R;

import java.util.List;

public class ArtistAdapter extends ArrayAdapter<Artist> {
    public ArtistAdapter(@NonNull Context context, int resource, @NonNull List<Artist> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.item_artist, null);
        }

        TextView tvName = v.findViewById(R.id.tv_name);
        ImageView ivArtistPic = v.findViewById(R.id.iv_artist_pic);
        ImageView btnPlay = v.findViewById(R.id.btn_play);

        Artist artist = getItem(position);

        tvName.setText(artist.getName());

        switch (position){
            case 0:{
                ivArtistPic.setImageResource(R.drawable.angele);
                break;
            }
            case 1:{
                ivArtistPic.setImageResource(R.drawable.aya);
                break;
            }
            case 2:{
                ivArtistPic.setImageResource(R.drawable.beo);
                break;
            }
            case 3:{
                ivArtistPic.setImageResource(R.drawable.dadju);
                break;
            }
            case 4:{
                ivArtistPic.setImageResource(R.drawable.drake);
                break;
            }
            case 5:{
                ivArtistPic.setImageResource(R.drawable.dualipa);
                break;
            }
            case 6:{
                ivArtistPic.setImageResource(R.drawable.ninho);
                break;
            }
            case 7:{
                ivArtistPic.setImageResource(R.drawable.pnl);
                break;
            }
            case 8:{
                ivArtistPic.setImageResource(R.drawable.stromae);
                break;
            }
            case 9:{
                ivArtistPic.setImageResource(R.drawable.weeknd);
                break;
            }
        }

        btnPlay.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(artist.getUrl()));
            view.getContext().startActivity(intent);
        });

        return v;
    }
}
