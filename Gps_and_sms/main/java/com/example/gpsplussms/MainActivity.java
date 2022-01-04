package com.example.gpsplussms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.SEND_SMS;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    LocationListener lis;
    String s1,s2;
    EditText e1;
    Button b1;
    String s3=" ";
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{READ_SMS,SEND_SMS,RECEIVE_SMS,READ_PHONE_STATE},1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.ee);
        s1=" ";
        s2=" ";

        b1=findViewById(R.id.button);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        lis = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                s1=""+location.getLatitude();
                s2=""+location.getLongitude();
                s3="Latitude"+":  "+s1+"\n"+"Longitude"+":  "+s2;
                System.out.print(s3.toString());
            }


        };
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            locationManager.requestLocationUpdates("gps",5000,1,lis);
                SmsManager mng= SmsManager.getDefault();
                System.out.println(s3.toString());
                mng.sendTextMessage(e1.getText().toString(),null,s3.toString(),null,null);
            }
        });

    }
}