package com.example.myapplication.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Domain.UserResponse;
import com.example.myapplication.IntroActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.TicketsActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername,etPassword;
    private String password,username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        //btnLogin = findViewById(R.id.btn_intro_login);

    }

    public void login(View view) {
        String url ="https://webapp-220801095131.azurewebsites.net/api/AuthManagement/login";
        String pseudo =etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        System.out.println("ici   "+password+" "+pseudo);

        try {
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("pseudo", pseudo);
            jsonParams.put("password", password);



            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    jsonParams,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            UserResponse user = convertToUserResponseObject(response);
                            if(user.getIsSuccess()=="true"){
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }
                        }
                    },
                    new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivity.this, "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                        }
                    });

            Volley.newRequestQueue(getApplicationContext()).
                    add(request);

        } catch(JSONException ex){
            // Catch if something went wrong with the params
        }
    }
    public UserResponse convertToUserResponseObject(JSONObject jsonObject){
        String jsonString = jsonObject.toString();
        Gson gson = new Gson();
         UserResponse user= gson.fromJson(jsonString, UserResponse.class);
         return user;
    }

}