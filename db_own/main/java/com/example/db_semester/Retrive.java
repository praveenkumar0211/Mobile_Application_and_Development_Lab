package com.example.db_semester;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Retrive extends AppCompatActivity {
    SQLiteDatabase db;
    Button b6;
    EditText e5;
    TextView t4;
    Cursor rs;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrive);
        db=openOrCreateDatabase("db",MODE_PRIVATE,null);
        b6=findViewById(R.id.button6);
        e5=findViewById(R.id.editTextTextPersonName3);
        t4=findViewById(R.id.textView6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=e5.getText().toString();
                rs=db.rawQuery("SELECT * FROM EMPLOYEESEM WHERE NAME  = ?;",new String[]{name});
                rs.moveToFirst();
                try{
                    t4.setText(rs.getString(0)+" "+rs.getString(1));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "no data", Toast.LENGTH_SHORT).show();
                    t4.setText("No such employee");

                }
            }
        });
    }
}
