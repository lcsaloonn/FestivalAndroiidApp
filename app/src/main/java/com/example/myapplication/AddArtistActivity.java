package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddArtistActivity extends AppCompatActivity {
    public static final String KEY_NAME = "name";
//    public static final String KEY_URL = "url";
    private Button btnCreate;
    private EditText etName, etUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_artist);

        btnCreate = findViewById(R.id.btn_add_artist_create);
        etName = findViewById(R.id.et_add_artist_name);
//        etUrl = findViewById(R.id.et_add_artist_url);

        btnCreate.setOnClickListener(view -> {
            String name = etName.getText().toString();
//            String url = etUrl.getText().toString();
            Intent intent = new Intent();
            intent.putExtra(KEY_NAME, name);
//            intent.putExtra(KEY_URL, url);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}