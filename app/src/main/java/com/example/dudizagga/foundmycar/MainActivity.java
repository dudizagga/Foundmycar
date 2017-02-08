package com.example.dudizagga.foundmycar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Uname, kind, number, location;
    public static MediaPlayer med;
    WebView webView;
    /*  String gps=MapsActivity.myLocation!=null?
              MapsActivity.myLocation.getLatitude()+","+MapsActivity.myLocation.getLongitude():
              "0.00,0.00";*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPointers();


    }

    private void setPointers() {
        webView = (WebView) findViewById(R.id.map2);
        Uname = (TextView) findViewById(R.id.nameYossi);
        kind = (TextView) findViewById(R.id.carKindV);
        number = (TextView) findViewById(R.id.carNum);
        location = (TextView) findViewById(R.id.location);
        med = MediaPlayer.create(this, R.raw.sound);


        SharedPreferences userPref = getSharedPreferences("users", 0);
        String yossi = userPref.getString("userName", "יוסי כהן");
        String kindd = userPref.getString("carKind", "הונדה");
        String num = userPref.getString("carNum", "11-222-33");

        Uname.setText(yossi);
        kind.setText(kindd);
        number.setText(num);

        double longitude = (double) userPref.getFloat("longitude", (float) 34.849647);
        double latitude = (double) userPref.getFloat("latitude", (float) 32.032133);

        location.setText(latitude + "," + longitude);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.co.il/maps/place/" + latitude + "," + longitude);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mapsPage:
                startActivity(new Intent(MainActivity.this, Maps.class));
                med.start();
                break;
            case R.id.settings:
                startActivity(new Intent(MainActivity.this, Settings.class));
                med.start();
                break;


        }
        return super.onOptionsItemSelected(item);
    }



    /*  @Override
    public void onMapReady(GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            return;
        }
        googleMap.addMarker(new MarkerOptions().position(college).title("המרכז ללימודי אקדמיים"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(college, 16));
        googleMap.getMinZoomLevel();


    } */
}


