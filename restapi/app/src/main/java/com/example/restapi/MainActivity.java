package com.example.restapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    final TextView textView = (TextView) findViewById(R.id.text);
    // Instantiate the RequestQueue.
    RequestQueue queue = Volley.newRequestQueue(this);
    String url ="http://192.168.43.114:5000/api/";

    // Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    textView.setText("Response is: "+ response.toString());
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            textView.setText("That didn't work!::"+ error.toString());
        }
    });
queue.add(stringRequest);

}

}