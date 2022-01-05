package com.example.db_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        db=openOrCreateDatabase("db",MODE_PRIVATE,null);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        db.execSQL("DROP TABLE IF EXISTS EMPLOYEESEM;");
        db.execSQL("CREATE TABLE EMPLOYEESEM(NAME VARCHAR(30),AGE VARCHAR(30));");
        Toast.makeText(getApplicationContext(), "db created", Toast.LENGTH_SHORT).show();
    }
});
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(getApplicationContext(),Insert.class);
        MainActivity.this.startActivity(myIntent);
    }
});
b3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(getApplicationContext(),Retrive.class);
        MainActivity.this.startActivity((myIntent));
    }
});

    }
}