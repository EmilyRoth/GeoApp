package com.example.geoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class mapActivity extends AppCompatActivity {

    private GoogleMap mMap;
    // takes in the next activity to do the map
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  SupportMapFragment map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
        Intent intent = getIntent();
        String address = intent.getStringExtra("address");
        TextView tv = findViewById(R.id.textView);
        tv.setText(address);
        setContentView(R.layout.activity_map);
    }
}
