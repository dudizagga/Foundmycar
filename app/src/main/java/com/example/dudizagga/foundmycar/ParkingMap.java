package com.example.dudizagga.foundmycar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.maps.model.LatLng;

import static android.location.LocationManager.GPS_PROVIDER;
import static com.example.dudizagga.foundmycar.MainActivity.latitude;
import static com.example.dudizagga.foundmycar.MainActivity.longitude;
import static com.example.dudizagga.foundmycar.MainActivity.med;
import static com.example.dudizagga.foundmycar.Maps.minTime;

public class ParkingMap extends AppCompatActivity {
    WebView map;
    LocationManager locationManager;
    LocationListener listener;
    Location location;
    Maps maps = new Maps();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_map);
        map = (WebView) findViewById(R.id.map2);

        this.context = this;
        location = new Location(GPS_PROVIDER);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                                PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                locationManager.requestLocationUpdates(GPS_PROVIDER, minTime, 0, (LocationListener) context);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        map.setWebViewClient(new WebViewClient());
        WebSettings settings = map.getSettings();
        settings.setJavaScriptEnabled(true);
        map.loadUrl("https://www.google.co.il/maps/search/חניון/@" +latitude +
                "," + longitude + ",13z");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                startActivity(new Intent(this, Maps.class));
                med.start();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return super.onCreateOptionsMenu(menu);


    }

}