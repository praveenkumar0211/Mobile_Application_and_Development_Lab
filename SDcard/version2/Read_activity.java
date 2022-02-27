package com.example.sd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadActivity extends AppCompatActivity {
    Button b3;
    TextView t1;
    EditText e1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        b3=findViewById(R.id.button2);
        t1=findViewById(R.id.textView);
        e1=findViewById(R.id.fnsearch);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f_name=e1.getText().toString();
                String line="";
                String f_content="";
                File file = new File(getExternalFilesDir("myfiles"),f_name+".txt");
                FileInputStream FIS = null;
                try{
                    FIS=new FileInputStream(file);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                BufferedReader BIR= new BufferedReader(new InputStreamReader(FIS));
            while(true){

                try{
                    if(!((line=BIR.readLine())!=null)) break;
                }catch (IOException e){
    e.printStackTrace();
                }
                f_content+=line;
            }
            t1.setText(f_content);
            }
        });
    }
}
