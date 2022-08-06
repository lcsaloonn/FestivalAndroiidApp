package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Adapter.ArtistAdapter;
import com.example.myapplication.Adapter.TicketAdapter;
import com.example.myapplication.Domain.Artist;
import com.example.myapplication.Domain.ArtistApi;
import com.example.myapplication.Domain.Ticket;
import com.example.myapplication.Domain.TicketApi;
import com.example.myapplication.data.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineUpActivity extends AppCompatActivity {
    private ListView lvArtists;
    private List<Artist> artistList;
    private ArtistAdapter artistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_up);

        //initArtistList();
        getAllArtists();

        /**
        lvArtists = findViewById(R.id.lv_admin_artists);
        artistAdapter = new ArtistAdapter(
                this,
                R.id.lv_admin_artists,
                artistList);

        lvArtists.setAdapter(artistAdapter); */
    }

    private void initArtistList() {
        //artistList = new ArrayList<>();
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


    private void getAllArtists(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://webapp-220801095131.azurewebsites.net/api/Artist",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String  response) {
                        jsonToJava(response);
                        Log.d("res", response);


                        if (response.equals("success")) {
                            Intent intent = new Intent(LineUpActivity.this, Result.Success.class);
                            startActivity(intent);
                            finish();

                        } else if (response.equals("failure")) {
                            Toast.makeText(LineUpActivity.this, "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LineUpActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                System.out.println(error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();

                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

    public void jsonToJava(String response){
        Gson gson = new Gson();
        Type artistListType = new TypeToken<ArrayList<ArtistApi>>(){}.getType();
        ArrayList<ArtistApi> artistArray = gson.fromJson(response, artistListType);
        createArtistList(artistArray);
    }

    public void createArtistList(ArrayList<ArtistApi> list){
        artistList = new ArrayList<>();
        initArtistList();
        for(ArtistApi artist : list) {
            System.out.println(artist);

            artistList.add(new Artist(artist.getMusicName(), artist.getMusicUrl()));
        }
        lvArtists = findViewById(R.id.lv_admin_artists);
        artistAdapter = new ArtistAdapter(
                this,
                R.id.lv_admin_artists,
                artistList);

        lvArtists.setAdapter(artistAdapter);
    }
}