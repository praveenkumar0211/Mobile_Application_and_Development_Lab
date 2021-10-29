package com.example.gps_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    Button b1;
    LocationListener lis;
    LocationManager locMan;
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView3);
        b1=findViewById(R.id.button);
        locMan=(LocationManager) getSystemService(LOCATION_SERVICE);
        lis = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                t1.setText(""+location.getLatitude());
                t2.setText(""+location.getLongitude());
            }
            @Override
            public void onStatusChanged(String s,int i,Bundle bundle){

            }
        };
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        b1.setOnClickListener( view -> {
            locMan.requestLocationUpdates("gps",5000,1,lis);
        });

    }
}