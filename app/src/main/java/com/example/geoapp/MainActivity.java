package com.example.geoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String apiKey = "AIzaSyDD9iujxZ9DbgjCcYOIEnNIvgShzQIwM6Q";
    private static final String baseUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private static String address;
// https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=YOUR_API_KEY
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ein = findViewById(R.id.et_address);
        address = 
    }

    public static String createURL(String parameter){
        String url = null;
        url = baseUrl + "1600+Amphitheatre+Parkway,+Mountain+View,+CA" + "=" + "&key=" + apiKey;
        return url;
    }
}
