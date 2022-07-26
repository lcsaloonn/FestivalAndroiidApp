package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.Adapter.ArtistAdapter;
import com.example.myapplication.Domain.Artist;

import java.util.ArrayList;
import java.util.List;

public class LineUpActivity extends AppCompatActivity {
    private ListView lvArtists;
    private List<Artist> artistList;
    private ArtistAdapter artistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_up);

        initArtistList();

        lvArtists = findViewById(R.id.lv_admin_artists);
        artistAdapter = new ArtistAdapter(
                this,
                R.id.lv_admin_artists,
                artistList);

        lvArtists.setAdapter(artistAdapter);
    }

    private void initArtistList() {
        artistList = new ArrayList<>();
        artistList.add(new Artist( "Angele", "https://www.youtube.com/watch?v=a79iLjV-HKw"));
        artistList.add(new Artist( "Aya Nakamura", "https://www.youtube.com/watch?v=3zsPWw2H9PE"));
        artistList.add(new Artist( "Bigflo et Oli", "https://www.youtube.com/watch?v=8AF-Sm8d8yk"));
        artistList.add(new Artist( "Dadju", "https://www.youtube.com/watch?v=mmc2sCXrTws"));
        artistList.add(new Artist( "Drake", "https://www.youtube.com/watch?v=THVbtGqEO1o"));
        artistList.add(new Artist( "Dua Lipa", "https://www.youtube.com/watch?v=BC19kwABFwc"));
        artistList.add(new Artist( "Ninho", "https://www.youtube.com/watch?v=5lzbP4ddQz8"));
        artistList.add(new Artist( "PNL", "https://www.youtube.com/watch?v=u8bHjdljyLw"));
        artistList.add(new Artist( "Stromae", "https://www.youtube.com/watch?v=P3QS83ubhHE"));
        artistList.add(new Artist( "The Weeknd", "https://www.youtube.com/watch?v=u9n7Cw-4_HQ"));
    }
}