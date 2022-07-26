package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Adapter.ArtistAdapter;
import com.example.myapplication.Adapter.ArtistAdminAdapter;
import com.example.myapplication.Domain.Artist;
import com.example.myapplication.Domain.ArtistAdmin;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    private Button btnAddArtist;
    private static final int REQ_CODE_ADD_ARTIST_ACTIVITY = 1;
    private ListView lvArtistsAdmin;
    private List<ArtistAdmin> artistAdminList;
    private ArtistAdminAdapter artistArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        artistAdminList = new ArrayList<>();
        artistAdminList.add(new ArtistAdmin( "Angele"));

        initArtistList();

        btnAddArtist = findViewById(R.id.btn_admin_add);
        btnAddArtist.setOnClickListener(view -> {
            Intent intent = new Intent(AdminActivity.this, AddArtistActivity.class);
            startActivityForResult(intent, REQ_CODE_ADD_ARTIST_ACTIVITY);
        });
    }

    private void initArtistList() {
        lvArtistsAdmin = findViewById(R.id.lv_admin_artists);
        artistArrayAdapter = new ArtistAdminAdapter(
                this,
                R.id.lv_admin_artists,
                artistAdminList);

        lvArtistsAdmin.setAdapter(artistArrayAdapter);

        lvArtistsAdmin.setOnItemClickListener(this::onItemClick);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Remove
        artistAdminList.remove(artistAdminList.get(position));
        initArtistList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE_ADD_ARTIST_ACTIVITY && resultCode == RESULT_OK){
            String name = data.getStringExtra(AddArtistActivity.KEY_NAME);
//            String url = data.getStringExtra(AddArtistActivity.KEY_URL);

            ArtistAdmin artistAdmin = new ArtistAdmin(name);
            artistAdminList.add(artistAdmin);
            initArtistList();
        }
    }
}