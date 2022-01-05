package com.example.db_semester;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Insert extends AppCompatActivity {
Button b4;
EditText e1,e2;
SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        b4=findViewById(R.id.button4);
        db=openOrCreateDatabase("db",MODE_PRIVATE,null);
        e1=findViewById(R.id.editTextTextPersonName);
        e2=findViewById(R.id.editTextTextPersonName2);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("INSERT INTO EMPLOYEESEM VALUES(?,?);",new String[]{e1.getText().toString(),e2.getText().toString()});
                Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
