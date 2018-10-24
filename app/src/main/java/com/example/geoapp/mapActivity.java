package com.example.geoapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GaeRequestHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.SupportMapFragment;

public class mapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String apiKey = "AIzaSyA-3fRqWzxM3VjT9krfB3U0WFgI6utSNAI";
    private GoogleMap mMap;
    private double lat;
    private double lng;
    private String formattedAddress;

    //  private GoogleMap mMap;
    // takes in the next activity to do the map
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        String address = intent.getStringExtra("address");
//        TextView tv = findViewById(R.id.tv_address);

        GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            // "1600 Amphitheatre Parkway Mountain View, CA 94043"
            results = GeocodingApi.geocode(context,
                    address).await();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0]));
        lat = results[0].geometry.location.lat;
        lng = results[0].geometry.location.lng;
        formattedAddress = results[0].formattedAddress;

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng location = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(location).title(formattedAddress));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}
