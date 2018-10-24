package com.example.geoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String apiKey = "AIzaSyDD9iujxZ9DbgjCcYOIEnNIvgShzQIwM6Q";
    private static final String baseUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private static String address;
    Button nextButton;
    static EditText input;
// https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=YOUR_API_KEY
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.et_address);
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // method

                // create URL

                // pass it to the client

                // get lat and long

                // bundle
                Intent intent = new Intent(v.getContext(), mapActivity.class);
                String pass = createURL();
                intent.putExtra("address", pass);
                startActivity(intent);

                // put into map activity

            }
        });
    }




    public static String createURL(){
        String url = null;
        address = String.valueOf(input);

        url = baseUrl + "1600+Amphitheatre+Parkway,+Mountain+View,+CA" + "=" + "&key=" + apiKey;
        return url;
    }
}
