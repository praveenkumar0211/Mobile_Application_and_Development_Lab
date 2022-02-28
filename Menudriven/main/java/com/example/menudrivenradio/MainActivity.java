package com.example.menudrivenradio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=findViewById(R.id.radioButton);
        r2=findViewById(R.id.radioButton2);

r1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent myintent = new Intent(getApplicationContext(),WebTech.class);
        MainActivity.this.startActivity(myintent);
    }
});
r2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent myintent = new Intent(getApplicationContext(),Network.class);
        MainActivity.this.startActivity(myintent);
    }
});
    }
}